package com.blankj.utilcode.util

import java.io.File

object FileIOUtils {
    @JvmStatic
    fun writeFileFromString(filePath: String?, content: String?): Boolean {
        if (filePath.isNullOrEmpty()) return false
        return try {
            val file = File(filePath)
            file.parentFile?.mkdirs()
            file.writeText(content ?: "")
            true
        } catch (ignored: Throwable) {
            false
        }
    }
}
