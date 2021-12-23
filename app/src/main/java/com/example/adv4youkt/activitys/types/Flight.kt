package com.example.adv4youkt.activitys.types

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.adv4youkt.R
import com.example.adv4youkt.activitys.MakingAnOrder
import com.example.adv4youkt.activitys.Reviews

class Flight : AppCompatActivity(), View.OnClickListener {

    var placeAnOrder: Button? = null
    var reviews: Button? = null
    var reviewsTW: TextView? = null
    var placeAnOrderTW: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flight)
        placeAnOrder = findViewById<Button>(R.id.place_an_order)
        reviews = findViewById<Button>(R.id.reviews_button)
        reviewsTW = findViewById<TextView>(R.id.reviews_tw)
        placeAnOrderTW = findViewById<TextView>(R.id.place_an_order_tw)
        placeAnOrder!!.setOnClickListener(this)
        placeAnOrderTW!!.setOnClickListener(this)
        reviews!!.setOnClickListener(this)
        reviewsTW!!.setOnClickListener(this)
    }

    @SuppressLint("NonConstantResourceId")
    override fun onClick(view: View) {
        val newActivity: Intent
        when (view.id) {
            R.id.reviews_button, R.id.reviews_tw -> {
                newActivity = Intent(this@Flight, Reviews::class.java)
                newActivity.putExtra("type", "Флайтовый")
                startActivity(newActivity)
            }
            R.id.place_an_order, R.id.place_an_order_tw -> {
                newActivity = Intent(this@Flight, MakingAnOrder::class.java)
                newActivity.putExtra("type", "Флайтовый")
                startActivity(newActivity)
            }
        }
    }
}