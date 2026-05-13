package com.blankj.utilcode.util

import android.util.Log

object LogUtils {
    private const val TAG = "MDWechat"

    @JvmStatic
    fun i(msg: Any?) {
        Log.i(TAG, msg?.toString() ?: "null")
    }
}
