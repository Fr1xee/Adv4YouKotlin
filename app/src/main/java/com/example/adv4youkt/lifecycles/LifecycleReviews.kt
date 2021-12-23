package com.example.adv4youkt.lifecycles

import android.annotation.SuppressLint
import com.example.adv4youkt.activitys.Reviews.Companion.viewModel
import com.example.adv4youkt.activitys.Reviews.Companion.setmReviewConsistent
import com.example.adv4youkt.activitys.Reviews.Companion.recyclerView
import com.example.adv4youkt.activitys.Reviews.Companion.setmReviewFlight
import com.example.adv4youkt.activitys.Reviews.Companion.setmReviewImpulsive
import com.example.adv4youkt.activitys.Reviews.Companion.setmReviewSeasonal
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.Lifecycle
import com.example.adv4youkt.activitys.Reviews
import com.example.adv4youkt.DataFromDB
import com.example.adv4youkt.pojos.pojos_for_review.ReviewConsistent
import com.example.adv4youkt.pojos.pojos_for_review.ReviewFlight
import com.example.adv4youkt.pojos.pojos_for_review.ReviewImpulsive
import com.example.adv4youkt.pojos.pojos_for_review.ReviewSeasonal


class LifecycleReviews : LifecycleObserver, LifecycleOwner {

    var consistent = false
    var flight = false
    var impulsive = false
    var seasonal = false

    @SuppressLint("NotifyDataSetChanged")
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun initViewModel() {
        when (Reviews.intent!!.getStringExtra("type")) {
            "Последовательно-постоянный" -> viewModel!!.reviewConsistent!!.observe(this, { reviewConsistent ->
                    setmReviewConsistent(reviewConsistent as List<ReviewConsistent>?)
                    if (!consistent) {
                        DataFromDB.getDataFromDB("consistent")
                        consistent = true
                    } else {
                        recyclerView!!.adapter!!.notifyDataSetChanged()
                    }
                })
            "Флайтовый" -> viewModel!!.reviewFlight!!.observe(this, { reviewFlight ->
                setmReviewFlight(reviewFlight as List<ReviewFlight>?)
                if (!flight) {
                    DataFromDB.getDataFromDB("flight")
                    flight = true
                } else {
                    recyclerView!!.adapter!!.notifyDataSetChanged()
                }
            })
            "Импульсивный" -> viewModel!!.reviewImpulsive!!.observe(this, { reviewImpulsive ->
                setmReviewImpulsive(reviewImpulsive as List<ReviewImpulsive>?)
                if (!impulsive) {
                    DataFromDB.getDataFromDB("impulsive")
                    impulsive = true
                } else {
                    recyclerView!!.adapter!!.notifyDataSetChanged()
                }
            })
            "Сезонный" -> viewModel!!.reviewSeasonal!!.observe(this, { reviewSeasonal ->
                setmReviewSeasonal(reviewSeasonal as List<ReviewSeasonal>?)
                if (!seasonal) {
                    DataFromDB.getDataFromDB("seasonal")
                    seasonal = true
                } else {
                    recyclerView!!.adapter!!.notifyDataSetChanged()
                }
            })
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun closeActivity() {
        consistent = false
        flight = false
        impulsive = false
        seasonal = false
    }

    override fun getLifecycle(): Lifecycle {
        return Reviews.lifecycle!!
    }
}