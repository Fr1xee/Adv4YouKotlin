package com.example.adv4youkt

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Lifecycle
import com.example.adv4youkt.activitys.types.Consistent
import com.example.adv4youkt.activitys.types.Flight
import com.example.adv4youkt.activitys.types.Impulsive
import com.example.adv4youkt.activitys.types.Seasonal
import com.example.adv4youkt.lifecycles.LifecycleOption

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var mConsistent: Button? = null
    var mImpulsive: Button? = null
    var mSeasonal: Button? = null
    var mFlight: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mConsistent = findViewById<View>(R.id.consistent) as Button
        mImpulsive = findViewById<View>(R.id.impulsive) as Button
        mSeasonal = findViewById<View>(R.id.seasonal) as Button
        mFlight = findViewById<View>(R.id.flight) as Button
        mConsistent!!.setOnClickListener(this)
        mImpulsive!!.setOnClickListener(this)
        mSeasonal!!.setOnClickListener(this)
        mFlight!!.setOnClickListener(this)
        val setLifecycle = LifecycleOption()
        Companion.lifecycle = lifecycle
        lifecycle.addObserver(setLifecycle)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        val constraintLayout = findViewById<ConstraintLayout>(R.id.constraint)
        when (id) {
            R.id.white -> {
                constraintLayout.setBackgroundColor(Color.WHITE)
                return true
            }
            R.id.black -> {
                constraintLayout.setBackgroundColor(Color.GRAY)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    @SuppressLint("NonConstantResourceId")
    override fun onClick(view: View) {
        val intentNewActivity: Intent
        when (view.id) {
            R.id.consistent -> {
                intentNewActivity = Intent(this@MainActivity, Consistent::class.java)
                startActivity(intentNewActivity)
            }
            R.id.impulsive -> {
                intentNewActivity = Intent(this@MainActivity, Impulsive::class.java)
                startActivity(intentNewActivity)
            }
            R.id.seasonal -> {
                intentNewActivity = Intent(this@MainActivity, Seasonal::class.java)
                startActivity(intentNewActivity)
            }
            R.id.flight -> {
                intentNewActivity = Intent(this@MainActivity, Flight::class.java)
                startActivity(intentNewActivity)
            }
        }
    }

    companion object {
        var lifecycle: Lifecycle? = null
    }
}