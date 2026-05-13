package com.blankj.utilcode.util

import android.content.Context
import android.widget.Toast
import com.blanke.mdwechat.Objects

object ToastUtils {
    @JvmStatic
    fun showShort(text: CharSequence?) {
        show(text, Toast.LENGTH_SHORT)
    }

    @JvmStatic
    fun showShort(resId: Int) {
        val context = getContext() ?: return
        show(context.getString(resId), Toast.LENGTH_SHORT)
    }

    @JvmStatic
    fun showLong(text: CharSequence?) {
        show(text, Toast.LENGTH_LONG)
    }

    private fun show(text: CharSequence?, duration: Int) {
        val context = getContext() ?: return
        Toast.makeText(context, text ?: "", duration).show()
    }

    private fun getContext(): Context? {
        Objects.Main.LauncherUI.get()?.let { return it }
        return try {
            Class.forName("android.app.ActivityThread")
                    .getMethod("currentApplication")
                    .invoke(null) as? Context
        } catch (ignored: Throwable) {
            null
        }
    }
}
