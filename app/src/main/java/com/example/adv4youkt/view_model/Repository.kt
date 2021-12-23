package com.example.adv4youkt.view_model

import com.example.adv4youkt.dao.ReviewDatabase.Companion.getDatabase
import android.app.Application
import androidx.lifecycle.LiveData
import com.example.adv4youkt.pojos.pojos_for_review.ReviewConsistent
import com.example.adv4youkt.pojos.pojos_for_review.ReviewFlight
import com.example.adv4youkt.pojos.pojos_for_review.ReviewSeasonal
import com.example.adv4youkt.pojos.pojos_for_review.ReviewImpulsive
import com.example.adv4youkt.dao.ReviewDAO
import com.example.adv4youkt.dao.ReviewDatabase

class Repository(application: Application?) {

    var reviewConsistent: LiveData<List<ReviewConsistent?>?>?
    var reviewFlight: LiveData<List<ReviewFlight?>?>?
    var reviewSeasonal: LiveData<List<ReviewSeasonal?>?>?
    var reviewImpulsive: LiveData<List<ReviewImpulsive?>?>?
    var dao: ReviewDAO?

    fun insertReviewConsistent(reviewConsistent: ReviewConsistent?) {
        ReviewDatabase.dbWriteExecutor.execute { dao!!.insertReviewConsistent(reviewConsistent) }
    }

    fun insertReviewFlight(reviewFlight: ReviewFlight?) {
        ReviewDatabase.dbWriteExecutor.execute { dao!!.insertReviewFlight(reviewFlight) }
    }

    fun insertReviewImpulsive(reviewImpulsive: ReviewImpulsive?) {
        ReviewDatabase.dbWriteExecutor.execute { dao!!.insertReviewImpulsive(reviewImpulsive) }
    }

    fun insertReviewSeasonal(reviewSeasonal: ReviewSeasonal?) {
        ReviewDatabase.dbWriteExecutor.execute { dao!!.insertReviewSeasonal(reviewSeasonal) }
    }

    fun deleteReviewConsistent() {
        dao!!.deleteReviewConsistent()
    }

    fun deleteReviewFlight() {
        dao!!.deleteReviewFlight()
    }

    fun deleteReviewImpulsive() {
        dao!!.deleteReviewImpulsive()
    }

    fun deleteReviewSeasonal() {
        dao!!.deleteReviewSeasonal()
    }

    @JvmName("getReviewConsistent1")
    fun getReviewConsistent(): LiveData<List<ReviewConsistent?>?>? {
        return reviewConsistent;
    }

    @JvmName("getReviewFlight1")
    fun getReviewFlight(): LiveData<List<ReviewFlight?>?>? {
        return reviewFlight;
    }

    @JvmName("getReviewSeasonal1")
    fun getReviewSeasonal(): LiveData<List<ReviewSeasonal?>?>? {
        return reviewSeasonal;
    }

    @JvmName("getReviewImpulsive1")
    fun getReviewImpulsive(): LiveData<List<ReviewImpulsive?>?>? {
        return reviewImpulsive;
    }

    init {
        val rd = getDatabase(application!!)
        dao = rd!!.reviewDAO()
        reviewConsistent = dao!!.loadAllReviewConsistent()
        reviewFlight = dao!!.loadAllReviewFlight()
        reviewSeasonal = dao!!.loadAllReviewSeasonal()
        reviewImpulsive = dao!!.loadAllReviewImpulsive()
    }
}