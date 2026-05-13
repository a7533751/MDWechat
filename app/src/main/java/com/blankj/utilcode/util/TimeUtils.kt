package com.blankj.utilcode.util

import java.util.Calendar
import java.util.Date
import java.util.concurrent.TimeUnit

object TimeUtils {
    @JvmStatic
    fun isToday(timeMillis: Long): Boolean {
        val now = Calendar.getInstance()
        val target = Calendar.getInstance().apply { timeInMillis = timeMillis }
        return now.get(Calendar.ERA) == target.get(Calendar.ERA)
                && now.get(Calendar.YEAR) == target.get(Calendar.YEAR)
                && now.get(Calendar.DAY_OF_YEAR) == target.get(Calendar.DAY_OF_YEAR)
    }

    @JvmStatic
    fun getFitTimeSpan(date0: Date?, date1: Date?, precision: Int): String {
        if (date0 == null || date1 == null) return ""
        var duration = kotlin.math.abs(date0.time - date1.time)
        val units = arrayOf(
                TimeUnit.DAYS.toMillis(1) to "天",
                TimeUnit.HOURS.toMillis(1) to "小时",
                TimeUnit.MINUTES.toMillis(1) to "分钟",
                TimeUnit.SECONDS.toMillis(1) to "秒"
        )
        val parts = ArrayList<String>()
        for ((unitMillis, unitName) in units) {
            if (duration >= unitMillis) {
                val value = duration / unitMillis
                duration %= unitMillis
                parts.add("$value$unitName")
                if (parts.size >= precision) break
            }
        }
        return if (parts.isEmpty()) "0秒" else parts.joinToString("")
    }
}
