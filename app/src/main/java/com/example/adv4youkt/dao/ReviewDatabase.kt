package com.example.adv4youkt.dao

import android.content.Context
import com.example.adv4youkt.pojos.pojos_for_review.ReviewConsistent
import com.example.adv4youkt.pojos.pojos_for_review.ReviewFlight
import com.example.adv4youkt.pojos.pojos_for_review.ReviewImpulsive
import com.example.adv4youkt.pojos.pojos_for_review.ReviewSeasonal
import androidx.room.Database
import androidx.room.RoomDatabase
import kotlin.jvm.Volatile
import androidx.room.Room
import java.util.concurrent.Executors

@Database(
    entities = [ReviewConsistent::class, ReviewFlight::class, ReviewImpulsive::class, ReviewSeasonal::class],
    version = 1,
    exportSchema = false
)
abstract class ReviewDatabase : RoomDatabase() {
    abstract fun reviewDAO(): ReviewDAO?

    companion object {
        @Volatile
        private var INSTANCE: ReviewDatabase? = null
        private const val NUMBER_OF_THREADS = 4
        @JvmField
        val dbWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS)
        @JvmStatic
        fun getDatabase(context: Context): ReviewDatabase? {
            if (INSTANCE == null) {
                synchronized(ReviewDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            ReviewDatabase::class.java, "database"
                        )
                            .allowMainThreadQueries()
                            .build()
                    }
                }
            }
            return INSTANCE
        }
    }
}