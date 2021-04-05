package com.example.mccanalytic.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.mccanalytic.CategoriesActivity
import com.example.mccanalytic.DetailsActivity
import com.example.mccanalytic.R
import kotlinx.android.synthetic.main.activity_details.view.*
import kotlinx.android.synthetic.main.item_gategories.view.*

class ItemAdapter(val activity: Activity?, val data: MutableList<Item>, val click: OnClickItem):
    RecyclerView.Adapter<ItemAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imagesv= itemView.imacard
        val namev = itemView.name
        val desv = itemView.pricee
        val card = itemView.cardv
        val linearr = itemView.linear
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(activity).inflate(R.layout.item_gategories, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ItemAdapter.MyViewHolder, position: Int) {
        holder.imagesv.setImageResource(data[position].image)
        holder.namev.text = data[position].name
        holder.desv.text = data[position].price
        holder.linearr.setOnClickListener {
            var intent = Intent(activity, DetailsActivity::class.java)
            intent.putExtra("image" , data[position].image)
            intent.putExtra("name" , data[position].name)
            intent.putExtra("price" , data[position].price)
            activity!!.startActivity(intent)
        }
        holder.card.setOnClickListener {
            click.onClick(holder.adapterPosition)
        }
    }
    interface  OnClickItem {
        fun onClick(position: Int)

    }
}