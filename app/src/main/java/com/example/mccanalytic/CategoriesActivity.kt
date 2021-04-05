package com.example.mccanalytic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mccanalytic.adapter.Item
import com.example.mccanalytic.adapter.ItemAdapter
import kotlinx.android.synthetic.main.activity_categories.*

class CategoriesActivity : AppCompatActivity(),ItemAdapter.OnClickItem {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)

        val id1 = intent.getStringExtra("id")

        val data = mutableListOf<Item>()
        if (id1 == "1"){
            data.add(Item("Hypercker","23$",R.drawable.f1))
            data.add(Item("Spaceti","20$",R.drawable.f2))
            data.add(Item("spaghetti","33$",R.drawable.f3))
        }else if (id1 == "2"){
            data.add(Item("MacBook Air","2000$",R.drawable.e2))
            data.add(Item("iphone 12pro Max","800$",R.drawable.e4))
            data.add(Item("iphone 11pro","650$",R.drawable.e3))
        }else if (id1 == "3"){
            data.add(Item("Shirt","43$",R.drawable.c2))
            data.add(Item("Girl's kit","50$",R.drawable.c1))
            data.add(Item("Girls' blouse","63$",R.drawable.c4))
        }

        rv_trending.layoutManager = LinearLayoutManager(this , LinearLayoutManager.VERTICAL , false)
        rv_trending.setHasFixedSize(true)
        val data_view= ItemAdapter(this,data,this)
        rv_trending.adapter=data_view

    }

    override fun onClick(position: Int) {
        val intent = Intent(this,DetailsActivity::class.java)
        startActivity(intent)
    }
}