package com.example.adv4youkt.activitys.types

import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.os.Bundle
import android.annotation.SuppressLint
import android.content.Intent
import android.view.View
import android.widget.Button
import com.example.adv4youkt.R
import com.example.adv4youkt.activitys.Reviews
import com.example.adv4youkt.activitys.MakingAnOrder

class Impulsive : AppCompatActivity(), View.OnClickListener {
    var placeAnOrder: Button? = null
    var reviews: Button? = null
    var reviewsTW: TextView? = null
    var placeAnOrderTW: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_impulsive)
        placeAnOrder = findViewById(R.id.place_an_order)
        reviews = findViewById(R.id.reviews_button)
        reviewsTW = findViewById(R.id.reviews_tw)
        placeAnOrderTW = findViewById(R.id.place_an_order_tw)
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
                newActivity = Intent(this@Impulsive, Reviews::class.java)
                newActivity.putExtra("type", "Импульсивный")
                startActivity(newActivity)
            }
            R.id.place_an_order, R.id.place_an_order_tw -> {
                newActivity = Intent(this@Impulsive, MakingAnOrder::class.java)
                newActivity.putExtra("type", "Импульсивный")
                startActivity(newActivity)
            }
        }
    }
}