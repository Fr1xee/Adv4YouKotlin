package com.example.adv4youkt.lifecycles

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.Lifecycle
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DatabaseReference

class LifecycleOption : LifecycleObserver, LifecycleOwner {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun init() {
        mDataBase = FirebaseDatabase.getInstance()
        ref = mDataBase!!.getReference("type")
    }


    companion object {
        var mDataBase: FirebaseDatabase? = null
        var ref: DatabaseReference? = null
        @JvmName("getRef1")
        @JvmStatic
        fun getRef(): DatabaseReference? {
            return ref
        }

        @JvmName("setRef1")
        fun setRef(ref: DatabaseReference?) {
            Companion.ref = ref
        }
    }

    override fun getLifecycle(): Lifecycle {
        TODO("Not yet implemented")
    }

}