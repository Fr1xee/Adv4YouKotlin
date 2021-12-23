package com.example.adv4youkt.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.adv4youkt.R
import androidx.lifecycle.ViewModelProvider
import com.example.adv4youkt.view_model.ReviewViewModel
import com.example.adv4youkt.lifecycles.LifecycleReviews
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import android.content.Intent
import android.view.View
import android.widget.Button
import com.example.adv4youkt.pojos.pojos_for_review.ReviewConsistent
import com.example.adv4youkt.pojos.pojos_for_review.ReviewFlight
import com.example.adv4youkt.pojos.pojos_for_review.ReviewImpulsive
import com.example.adv4youkt.pojos.pojos_for_review.ReviewSeasonal
import androidx.lifecycle.Lifecycle

class Reviews : AppCompatActivity(), View.OnClickListener {
    var addReview: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reviews)
        addReview = findViewById(R.id.add_review)
        addReview!!.setOnClickListener(this)
        Companion.intent = intent
        viewModel = ViewModelProvider(this).get(ReviewViewModel::class.java)
        val setLifecycle = LifecycleReviews()
        Companion.lifecycle = lifecycle
        Companion.lifecycle!!.addObserver(setLifecycle)
        recyclerView = findViewById(R.id.r_view)
        recyclerView!!.layoutManager = LinearLayoutManager(this)

//        initViewModel();
    }

    override fun onClick(view: View) {
        val newActivity = Intent(this@Reviews, SendReview::class.java)
        newActivity.putExtra("type", Companion.intent!!.getStringExtra("type"))
        startActivity(newActivity)
    }

    companion object {
        @JvmStatic
        var recyclerView: RecyclerView? = null
            private set
        @JvmStatic
        var viewModel: ReviewViewModel? = null
            private set
        @JvmField
        var intent: Intent? = null
        private var mReviewConsistent: List<ReviewConsistent>? = null
        private var mReviewFlight: List<ReviewFlight>? = null
        private var mReviewImpulsive: List<ReviewImpulsive>? = null
        private var mReviewSeasonal: List<ReviewSeasonal>? = null
        @JvmField
        var lifecycle: Lifecycle? = null
        @JvmStatic
        fun getmReviewConsistent(): List<ReviewConsistent>? {
            return mReviewConsistent
        }

        @JvmStatic
        fun setmReviewConsistent(mReviewConsistent: List<ReviewConsistent>?) {
            Companion.mReviewConsistent = mReviewConsistent
        }

        @JvmStatic
        fun getmReviewFlight(): List<ReviewFlight>? {
            return mReviewFlight
        }

        @JvmStatic
        fun setmReviewFlight(mReviewFlight: List<ReviewFlight>?) {
            Companion.mReviewFlight = mReviewFlight
        }

        @JvmStatic
        fun getmReviewImpulsive(): List<ReviewImpulsive>? {
            return mReviewImpulsive
        }

        @JvmStatic
        fun setmReviewImpulsive(mReviewImpulsive: List<ReviewImpulsive>?) {
            Companion.mReviewImpulsive = mReviewImpulsive
        }

        @JvmStatic
        fun getmReviewSeasonal(): List<ReviewSeasonal>? {
            return mReviewSeasonal
        }

        @JvmStatic
        fun setmReviewSeasonal(mReviewSeasonal: List<ReviewSeasonal>?) {
            Companion.mReviewSeasonal = mReviewSeasonal
        }
    }
}