package com.example.adv4youkt.view_model


import android.app.Application
import androidx.lifecycle.LiveData
import com.example.adv4youkt.pojos.pojos_for_review.ReviewConsistent
import com.example.adv4youkt.pojos.pojos_for_review.ReviewFlight
import com.example.adv4youkt.pojos.pojos_for_review.ReviewSeasonal
import com.example.adv4youkt.pojos.pojos_for_review.ReviewImpulsive

import androidx.lifecycle.AndroidViewModel

class ReviewViewModel(application: Application) : AndroidViewModel(application) {

    var repository: Repository = Repository(application)

    val reviewConsistent: LiveData<List<ReviewConsistent?>?>? = repository.getReviewConsistent()
    val reviewFlight: LiveData<List<ReviewFlight?>?>? = repository.getReviewFlight()
    val reviewSeasonal: LiveData<List<ReviewSeasonal?>?>? = repository.getReviewSeasonal()
    val reviewImpulsive: LiveData<List<ReviewImpulsive?>?>? = repository.getReviewImpulsive()

    fun insertReviewConsistent(reviewConsistent: ReviewConsistent?) {
        repository.insertReviewConsistent(reviewConsistent)
    }

    fun insertReviewFlight(reviewFlight: ReviewFlight?) {
        repository.insertReviewFlight(reviewFlight)
    }

    fun insertReviewImpulsive(reviewImpulsive: ReviewImpulsive?) {
        repository.insertReviewImpulsive(reviewImpulsive)
    }

    fun insertReviewSeasonal(reviewSeasonal: ReviewSeasonal?) {
        repository.insertReviewSeasonal(reviewSeasonal)
    }

    fun deleteReviewConsistent() {
        repository.deleteReviewConsistent()
    }

    fun deleteReviewFlight() {
        repository.deleteReviewFlight()
    }

    fun deleteReviewImpulsive() {
        repository.deleteReviewImpulsive()
    }

    fun deleteReviewSeasonal() {
        repository.deleteReviewSeasonal()
    }

}