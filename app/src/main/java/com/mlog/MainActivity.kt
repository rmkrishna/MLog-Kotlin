package com.mlog

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    val TAG: String?

    init {
        TAG = MainActivity::class?.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MLog.d("onCreate")
        MLog.d(TAG, "onCreate")
    }
}
