package `in`.rmkrishna.mlog

import `in`.rmkrishna.mlog.MLog
import android.content.pm.PackageManager
import android.os.Environment
import java.text.SimpleDateFormat
import java.util.*
import java.io.File
import android.os.StatFs




/**
 * Created by muthukrishnan on 30/05/17.
 */
class Util {

    companion object {

        fun generateLogFilePath(): String {

            val timestamp = System.currentTimeMillis()

            val folderName = getLoggingFolderOfThisApp()

            val f = File(folderName)

            // create the folder
            if (!f.isDirectory) {
                val ret = f.mkdirs()
                if (ret != true) {
                    return "" // return empty string if fail.
                }
            }

            // file name
            val sdf = SimpleDateFormat("yyyyMMdd_HHmmss_SSS", Locale.US)
            val fileName = folderName + File.separator + sdf.format(Date(timestamp)) + ".log"

            return fileName
        }

        fun getLoggingFolderOfThisApp(): String {

            val rootPath = Environment.getExternalStorageDirectory().getPath() + File.separator + MLog.folderName

            val sb = StringBuilder(130) // half of the max length of the path

            sb.append(rootPath)
            sb.append(File.separator)

            return sb.toString()
        }

        /**
         * This method will return the long time into Normal Date time with format
         * "2013 03 20 20:08:45".

         * @param time
         * *
         * *
         * @return
         */
        fun convertTime(time: Long): String {
            val date = Date(time)

            val format = SimpleDateFormat("yyyy MM dd HH:mm:ss", Locale.US)

            return format.format(date).toString()
        }

        /**
         * Get current application version name from package manager.

         * @return
         */
        fun getAppVersionName(): String? {
            val context = MLog.context

            var versionName: String? = null
            var info = context!!.getPackageManager().getPackageInfo(context!!.packageName, PackageManager.GET_SIGNATURES)


            if (info != null) {
                versionName = info!!.versionName
            }

            return versionName
        }

        /**
         * Get current application version code from package manager.

         * @return
         */
        fun getAppVersionCode(): Int {
            val context = MLog.context

            var info = context!!.getPackageManager().getPackageInfo(context!!.packageName, PackageManager.GET_SIGNATURES)

            var versionCode = -1

            if (info != null) {
                versionCode = info!!.versionCode
            }

            return versionCode
        }

        /**
         * @param requiredSize
         * *
         * *
         * @return
         */
        public fun doesSdcardHasEnufSpace(requiredSize: Double): Boolean {
            var spaceAvailable = false
            val path = Environment.getExternalStorageDirectory() ?: return false

            val filePath = path.path ?: return false

            var stat: StatFs? = null

            try {
                stat = StatFs(filePath)
            } catch (exception: IllegalArgumentException) {
                return false
            }

            val availSize = stat.availableBlocks.toDouble() * stat.blockSize.toDouble()

            if (requiredSize < availSize) {
                spaceAvailable = true
            }

            return spaceAvailable
        }

        public fun isSdCardPresent(): Boolean {
            var result = false
            val state = Environment.getExternalStorageState()

            if (Environment.MEDIA_MOUNTED == state) {
                result = true
            }

            return result
        }
    }
}