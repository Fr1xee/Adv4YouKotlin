package com.example.adv4youkt.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.adv4youkt.pojos.pojos_for_review.ReviewConsistent
import com.example.adv4youkt.pojos.pojos_for_review.ReviewFlight
import com.example.adv4youkt.pojos.pojos_for_review.ReviewImpulsive
import com.example.adv4youkt.pojos.pojos_for_review.ReviewSeasonal


@Dao
interface ReviewDAO {
    /** Запросы для таблицы Consistent
     */
    @Query("SELECT * FROM ReviewConsistent")
    fun loadAllReviewConsistent(): LiveData<List<ReviewConsistent?>?>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertReviewConsistent(reviewConsistent: ReviewConsistent?)

    @Query("DELETE FROM ReviewConsistent")
    fun deleteReviewConsistent()

    /** Запросы для таблицы Flight
     */
    @Query("SELECT * FROM ReviewFlight")
    fun loadAllReviewFlight(): LiveData<List<ReviewFlight?>?>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertReviewFlight(reviewFlight: ReviewFlight?)

    @Query("DELETE FROM ReviewFlight")
    fun deleteReviewFlight()

    /** Запросы для таблицы Impulse
     */
    @Query("SELECT * FROM ReviewImpulsive")
    fun loadAllReviewImpulsive(): LiveData<List<ReviewImpulsive?>?>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertReviewImpulsive(reviewImpulsive: ReviewImpulsive?)

    @Query("DELETE FROM ReviewImpulsive")
    fun deleteReviewImpulsive()

    /** Запросы для таблицы Seasonal
     */
    @Query("SELECT * FROM ReviewSeasonal")
    fun loadAllReviewSeasonal(): LiveData<List<ReviewSeasonal?>?>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertReviewSeasonal(reviewSeasonal: ReviewSeasonal?)

    @Query("DELETE FROM ReviewSeasonal")
    fun deleteReviewSeasonal()
}