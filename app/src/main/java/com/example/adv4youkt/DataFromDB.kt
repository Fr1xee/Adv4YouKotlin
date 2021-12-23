package com.example.adv4youkt

import com.example.adv4youkt.activitys.Reviews.Companion.viewModel
import com.example.adv4youkt.activitys.Reviews.Companion.recyclerView
import com.example.adv4youkt.activitys.Reviews.Companion.getmReviewConsistent
import com.example.adv4youkt.activitys.Reviews.Companion.getmReviewFlight
import com.example.adv4youkt.activitys.Reviews.Companion.getmReviewImpulsive
import com.example.adv4youkt.activitys.Reviews.Companion.getmReviewSeasonal
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.example.adv4youkt.lifecycles.LifecycleOption
import com.example.adv4youkt.pojos.pojos_for_review.ReviewConsistent
import com.example.adv4youkt.pojos.pojos_for_review.ReviewFlight
import com.example.adv4youkt.pojos.pojos_for_review.ReviewImpulsive
import com.example.adv4youkt.pojos.pojos_for_review.ReviewSeasonal

class DataFromDB {
    var type: String? = null

    companion object {
        fun getDataFromDB(type: String) {
            val vListener: ValueEventListener = object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    var snapshot = snapshot
                    when (type) {
                        "consistent" -> viewModel!!.deleteReviewConsistent()
                        "flight" -> viewModel!!.deleteReviewFlight()
                        "impulsive" -> viewModel!!.deleteReviewImpulsive()
                        "seasonal" -> viewModel!!.deleteReviewSeasonal()
                    }
                    snapshot = snapshot.child("/$type/reviews")
                    var i = 0
                    for (ds in snapshot.children) {
                        addDataToRoomDB(ds, type)
                        i++
                    }
                    when (type) {
                        "consistent" -> recyclerView!!.adapter = ReViewRecycler(
                            getmReviewConsistent()!!, null, null, null)
                        "flight" -> recyclerView!!.adapter =
                            ReViewRecycler(null, getmReviewFlight()!!, null, null)
                        "impulsive" -> recyclerView!!.adapter =
                            ReViewRecycler(null, null, getmReviewImpulsive()!!, null)
                        "seasonal" -> recyclerView!!.adapter =
                            ReViewRecycler(null, null, null, getmReviewSeasonal()!!)
                    }
                }

                override fun onCancelled(error: DatabaseError) {}
            }
            LifecycleOption.getRef()!!.addValueEventListener(vListener)
        }

        private fun addDataToRoomDB(ds: DataSnapshot, type: String) {
            when (type) {
                "consistent" -> {
                    val reviewConsistent = ReviewConsistent()
                    reviewConsistent.name = ds.child("name").value.toString()
                    reviewConsistent.review = ds.child("review").value.toString()
                    viewModel!!.insertReviewConsistent(reviewConsistent)
                }
                "flight" -> {
                    val reviewFlight = ReviewFlight()
                    reviewFlight.name = ds.child("name").value.toString()
                    reviewFlight.review = ds.child("review").value.toString()
                    viewModel!!.insertReviewFlight(reviewFlight)
                }
                "impulsive" -> {
                    val reviewImpulsive = ReviewImpulsive()
                    reviewImpulsive.name = ds.child("name").value.toString()
                    reviewImpulsive.review = ds.child("review").value.toString()
                    viewModel!!.insertReviewImpulsive(reviewImpulsive)
                }
                "seasonal" -> {
                    val reviewSeasonal = ReviewSeasonal()
                    reviewSeasonal.name = ds.child("name").value.toString()
                    reviewSeasonal.review = ds.child("review").value.toString()
                    viewModel!!.insertReviewSeasonal(reviewSeasonal)
                }
            }
        }
    }
}