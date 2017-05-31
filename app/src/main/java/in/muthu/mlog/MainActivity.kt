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

package `in`.muthu.mlog

import `in`.rmkrishna.mlog.MLog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mlog.R
import org.json.JSONArray
import org.json.JSONObject

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

        var jsonObject: JSONObject = JSONObject().apply {
            put("name", "Muthukrishnan Rajendran")
            put("device", "Device")
        }

        MLog.d(jsonObject)

        var jsonArray: JSONArray = JSONArray().apply {
            put("Message 1")
            put("Message 2")
            put("Message 3")
            put("Message 4")
            put("Message 5")
        }
        MLog.d(jsonArray)
    }
}
