package com.example.rafael.applicationtest.util

import android.content.Context

object Functions{

    /**
     * Dp to pixel conversion
     */
    fun dp2px(context: Context, dipValue: Float): Int {
        val m = context.resources.displayMetrics.density
        return (dipValue * m + 0.5f).toInt()
    }
}