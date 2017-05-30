package `in`.rmkrishna.mlog

import android.os.Handler
import android.os.HandlerThread
import android.os.Message
import android.os.Process


/**
 * Created by muthukrishnan on 27/05/17.
 */
internal object MFileLog {

    private val LOG = 150

    private var fileWriter: MFileWriter? = null

    private var handler: Handler? = null;

    internal fun init() {

        fileWriter = MFileWriter()
        fileWriter?.open()

        val handlerThread = HandlerThread("MyHandlerThread", Process.THREAD_PRIORITY_BACKGROUND)
        handlerThread.start()

        handler = object : Handler(handlerThread.looper) {
            override fun handleMessage(msg: Message) {
                when (msg.what) {
                    LOG -> {
                        var item: Item = msg.obj as Item

                        fileWriter?.logToFile(item.tag, item.msg, item.th)
                    }
                }
            }
        }
    }

    internal fun log(tag: String, msg: String, th: Throwable?) {
        handler?.sendMessage(Message.obtain(handler, LOG, Item(tag, msg, th)))
    }

    internal class Item constructor(var tag: String, var msg: String, var th: Throwable?)
}