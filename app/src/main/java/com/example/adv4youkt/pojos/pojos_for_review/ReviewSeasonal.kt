package com.example.adv4youkt.pojos.pojos_for_review

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ReviewSeasonal")
class ReviewSeasonal {
    @PrimaryKey(autoGenerate = true)
    var id = 0
    var name: String? = null
    var review: String? = null
}