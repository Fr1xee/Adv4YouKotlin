package com.example.adv4youkt.pojos.pojos_for_review

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ReviewFlight")
class ReviewFlight {
    @PrimaryKey(autoGenerate = true)
    var id = 0
    var name: String? = null
    var review: String? = null
}