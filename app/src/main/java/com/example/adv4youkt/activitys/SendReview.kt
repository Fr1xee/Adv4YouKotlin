package com.example.adv4youkt.activitys

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.adv4youkt.R
import com.example.adv4youkt.lifecycles.LifecycleOption
import com.example.adv4youkt.pojos.Review

class SendReview : AppCompatActivity(), View.OnClickListener {

    var sendReview: Button? = null
    var edName: EditText? = null
    var edReview: EditText? = null

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_review)
        sendReview = findViewById<Button>(R.id.send_review)
        edName = findViewById<EditText>(R.id.ed_name)
        edReview = findViewById<EditText>(R.id.ed_review)
        intent = getIntent()
        sendReview!!.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (edName!!.text.toString() == "" && edReview!!.text.toString() == "") {
            val toast: Toast = Toast.makeText(this, "Отсутсвет Имя/Комментарий", Toast.LENGTH_SHORT)
            toast.show()
        } else {
            val toast: Toast
            val name: String = edName!!.text.toString()
            val review: String = edReview!!.text.toString()
            val newOrder = Review(name, review)
            when (intent.getStringExtra("type")) {
                "Последовательно-постоянный" -> {
                    LifecycleOption.getRef()!!.child("/consistent/reviews").push().setValue(newOrder)
                    toast = Toast.makeText(this, "Ваш отзыв был отправлен", Toast.LENGTH_SHORT)
                    toast.show()
                    finish()
                }
                "Флайтовый" -> {
                    LifecycleOption.getRef()!!.child("/flight/reviews").push().setValue(newOrder)
                    toast = Toast.makeText(this, "Ваш отзыв был отправлен", Toast.LENGTH_SHORT)
                    toast.show()
                    finish()
                }
                "Импульсивный" -> {
                    LifecycleOption.getRef()!!.child("/impulsive/reviews").push().setValue(newOrder)
                    toast = Toast.makeText(this, "Ваш отзыв был отправлен", Toast.LENGTH_SHORT)
                    toast.show()
                    finish()
                }
                "Сезонный" -> {
                    LifecycleOption.getRef()!!.child("/seasonal/reviews").push().setValue(newOrder)
                    toast = Toast.makeText(this, "Ваш отзыв был отправлен", Toast.LENGTH_SHORT)
                    toast.show()
                    finish()
                }
            }
        }
    }

    companion object {
        var intent: Intent? = null
    }
}