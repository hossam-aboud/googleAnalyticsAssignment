package com.example.mccanalytic

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.analytics.FirebaseAnalytics
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_gategories.*
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {

    private lateinit var firebaseAnalytics: FirebaseAnalytics

    var timer =0

    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firebaseAnalytics = FirebaseAnalytics.getInstance(this)

        selectContect("a123", "dog", "image")

        xEvent("a12345", "xName")

        trackScreen("main screen")


        bu1.setOnClickListener {
            val inten = Intent(this, CategoriesActivity::class.java)
            inten.putExtra("id", "1")
            startActivity(inten)
        }
        bu2.setOnClickListener {
            val inten = Intent(this, CategoriesActivity::class.java)
            inten.putExtra("id", "2")
            startActivity(inten)
        }
        bu3.setOnClickListener {
            val inten = Intent(this, CategoriesActivity::class.java)
            inten.putExtra("id", "3")
            startActivity(inten)
        }


    }
    fun selectContect(id: String, name: String, contentType: String){
        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, id)
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, name)
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, contentType)
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle)
    }

    fun trackScreen(screenName:String){
        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.SCREEN_NAME, screenName)
        bundle.putString(FirebaseAnalytics.Param.SCREEN_CLASS, "MainActivity")
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, bundle)
    }

    fun xEvent(id: String, name: String){
        val params = Bundle()
        params.putString("id", id)
        params.putString("name", name)
        firebaseAnalytics.logEvent("xEvent", params)
    }


}