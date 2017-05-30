/*
 * Copyright 2017 Muthukrishnan R
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

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