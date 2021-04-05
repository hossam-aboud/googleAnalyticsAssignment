package com.example.mccanalytic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        var imagew = intent.getIntExtra("image",0)
        var namew = intent.getStringExtra("name")
        var pricew = intent.getStringExtra("price")

        prodect_image.setImageResource(imagew)
        t_name.setText(namew)
        price.setText(pricew)

    }
}