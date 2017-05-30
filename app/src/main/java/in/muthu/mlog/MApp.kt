package `in`.muthu.mlog

import `in`.rmkrishna.mlog.MLog
import android.app.Application

/**
 * Created by muthukrishnan on 27/05/17.
 */
class MApp : Application() {

    override fun onCreate() {
        super.onCreate()

        MLog.init(this, true, true)
    }
}