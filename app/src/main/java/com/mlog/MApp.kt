package com.mlog

import android.app.Application

/**
 * Created by muthukrishnan on 27/05/17.
 */
class MApp : Application() {

    override fun onCreate() {
        super.onCreate()

        MLog.isLogEnable = true
    }
}