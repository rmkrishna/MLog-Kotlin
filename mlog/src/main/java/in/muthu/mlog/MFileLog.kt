package `in`.muthu.mlog

import android.os.Handler
import android.os.HandlerThread
import android.os.Message
import android.util.Log


/**
 * Created by muthukrishnan on 27/05/17.
 */
public object MFileLog {

    private val LOG = 150

    private var fileWriter: MFileWriter? = null

    var handler: Handler? = null;

    public fun init() {

        fileWriter = MFileWriter()
        fileWriter?.open()

        val handlerThread = HandlerThread("MyHandlerThread")
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

    public fun log(tag: String, msg: String, th: Throwable?) {
        handler?.sendMessage(Message.obtain(handler, LOG, Item(tag, msg, th)))
    }

    class Item constructor(var tag: String, var msg: String, var th: Throwable?)
}