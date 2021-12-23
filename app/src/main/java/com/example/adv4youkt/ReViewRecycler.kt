package com.example.adv4youkt

import com.example.adv4youkt.pojos.pojos_for_review.ReviewConsistent
import com.example.adv4youkt.pojos.pojos_for_review.ReviewFlight
import com.example.adv4youkt.pojos.pojos_for_review.ReviewImpulsive
import com.example.adv4youkt.pojos.pojos_for_review.ReviewSeasonal
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import java.lang.IllegalStateException

class ReViewRecycler(
    var mValues1: List<ReviewConsistent>?,
    var mValues2: List<ReviewFlight>?,
    var mValues3: List<ReviewImpulsive>?,
    var mValues4: List<ReviewSeasonal>?
) : RecyclerView.Adapter<ReViewRecycler.ViewHolder>() {

    private val TYPE_ITEM1 = 0
    private val TYPE_ITEM2 = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View
        return when (viewType) {
            TYPE_ITEM1 -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.review_item_left, parent, false)
                ViewHolder(view)
            }
            TYPE_ITEM2 -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.review_item_right, parent, false)
                ViewHolder(view)
            }
            else -> throw IllegalStateException("Unexpected value: $viewType")
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            TYPE_ITEM1, TYPE_ITEM2 -> when {
                mValues2 != null -> {
                    holder.reviewersName.text = mValues2!![position].name
                    holder.review.text = mValues2!![position].review
                }
                mValues3 != null -> {
                    holder.reviewersName.text = mValues3!![position].name
                    holder.review.text = mValues3!![position].review
                }
                mValues4 != null -> {
                    holder.reviewersName.text = mValues4!![position].name
                    holder.review.text = mValues4!![position].review
                }
                else -> {
                    holder.reviewersName.text = mValues1!![position].name
                    holder.review.text = mValues1!![position].review
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return when {
            mValues2 != null -> {
                mValues2!!.size
            }
            mValues3 != null -> {
                mValues3!!.size
            }
            mValues4 != null -> {
                mValues4!!.size
            }
            else -> {
                mValues1!!.size
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position % 2 == 0) {
            TYPE_ITEM1
        } else {
            TYPE_ITEM2
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var reviewersName: TextView = itemView.findViewById(R.id.reviewers_name)
        var review: TextView = itemView.findViewById(R.id.review_tw)

    }
}