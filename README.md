# MLog-Kotlin
Simple Logging library for Android in Kotlin, It will help you to print the logs in Console and also it will store the logs in File in your mobile storage.

 [ ![Download](https://api.bintray.com/packages/rmkrishna/rmkrishna/mLog/images/download.svg) ](https://bintray.com/rmkrishna/rmkrishna/mLog/_latestVersion) [![Apache License V.2](https://img.shields.io/badge/license-Apache%20V.2-blue.svg)](https://github.com/rmkrishna/MLog-Kotlin/blob/master/LICENSE)

## Usage
### Dependency
```groovy
compile 'in.rmkrishna:mlog:0.0.3'
```

### Initialization

```Kotlin
MLog.init(this, true, true)
```
### How to use

```Kotlin
        // If tag is not provided, we will generate Tag based on your Activity and method name
        MLog.d("Calculate") // log a String without tag, 
        
        MLog.d(TAG, "onCreate") // log a String with tag

        var jsonObject: JSONObject = JSONObject().apply {
            put("name", "Muthukrishnan Rajendran")
            put("device", "Android")
        }

        MLog.d(jsonObject) // To log a Json object

        var jsonArray: JSONArray = JSONArray().apply {
            put("Message 1")
            put("Message 2")
            put("Message 3")
            put("Message 4")
            put("Message 5")
        }
        MLog.d(jsonArray) // To log a Json array
```

## License
<pre>

                                 Apache License
                           Version 2.0, January 2004
                        http://www.apache.org/licenses/

Copyright 2017 Muthukrishnan R

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
