package com.example.adv4youkt.activitys

import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.os.Bundle
import com.example.adv4youkt.R
import com.example.adv4youkt.activitys.MakingAnOrder
import android.widget.Toast
import com.example.adv4youkt.lifecycles.LifecycleOption
import android.content.Intent
import android.view.View
import android.widget.Button
import com.example.adv4youkt.pojos.Order

class MakingAnOrder : AppCompatActivity(), View.OnClickListener {

    var typeOfExtension: EditText? = null
    var edFullName: EditText? = null
    var edPhone: EditText? = null
    var edMoney: EditText? = null
    var makingAnOrder: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_making_an_order)
        typeOfExtension = findViewById(R.id.type_of_extension)
        edFullName = findViewById(R.id.ed_full_name)
        edPhone = findViewById(R.id.ed_phone)
        edMoney = findViewById(R.id.ed_money)
        makingAnOrder = findViewById(R.id.making_an_order)
        makingAnOrder!!.setOnClickListener(this)
        intent = intent
        typeOfExtension!!.setText(intent.getStringExtra("type"))
    }

    override fun onClick(view: View) {
        if (edFullName!!.text.toString() == "" && edPhone!!.text.toString() == "" && edMoney!!.text.toString() == "") {
            val toast =
                Toast.makeText(this, "Проверьте правильность ввода данных", Toast.LENGTH_SHORT)
            toast.show()
        } else {
            val toast: Toast
            val fullName = edFullName!!.text.toString()
            val phone = edPhone!!.text.toString()
            val money = edMoney!!.text.toString()
            val newOrder = Order(fullName, phone, money)
            when (typeOfExtension!!.text.toString()) {
                "Последовательно-постоянный" -> {
                    LifecycleOption.getRef()!!.child("/consistent/order").push().setValue(newOrder)
                    toast = Toast.makeText(
                        this,
                        "Заказ на продвижение был оформлен",
                        Toast.LENGTH_SHORT
                    )
                    toast.show()
                }
                "Флайтовый" -> {
                    LifecycleOption.getRef()!!.child("/flight/order").push().setValue(newOrder)
                    toast = Toast.makeText(
                        this,
                        "Заказ на продвижение был оформлен",
                        Toast.LENGTH_SHORT
                    )
                    toast.show()
                }
                "Импульсивный" -> {
                    LifecycleOption.getRef()!!.child("/impulsive/order").push().setValue(newOrder)
                    toast = Toast.makeText(
                        this,
                        "Заказ на продвижение был оформлен",
                        Toast.LENGTH_SHORT
                    )
                    toast.show()
                }
                "Сезонный" -> {
                    LifecycleOption.getRef()!!.child("/seasonal/order").push().setValue(newOrder)
                    toast = Toast.makeText(
                        this,
                        "Заказ на продвижение был оформлен",
                        Toast.LENGTH_SHORT
                    )
                    toast.show()
                }
            }
        }
    }

    companion object {
        var intent: Intent? = null
    }
}