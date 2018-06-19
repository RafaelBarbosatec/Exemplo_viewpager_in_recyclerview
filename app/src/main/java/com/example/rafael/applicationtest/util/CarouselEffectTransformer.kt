package br.com.ipiranga.abasteceai.Support.View

import android.content.Context
import android.support.v4.view.ViewPager
import android.view.View
import android.support.v4.view.ViewCompat



/**
 * Created by rafaelbarbosa on 10/01/18.
 */
class CarouselEffectTransformer(var context: Context) : ViewPager.PageTransformer{

    private var maxTranslateOffsetX: Int = 0
    private var viewPager: ViewPager? = null

    init {
        this.maxTranslateOffsetX = dp2px(context, 180f)
    }

    override fun transformPage(view: View, position: Float) {
        if (viewPager == null) {
            viewPager = view.parent as ViewPager
        }

        val leftInScreen = view.left - viewPager!!.scrollX
        val centerXInViewPager = leftInScreen + view.measuredWidth / 1.5
        val offsetX = centerXInViewPager - viewPager!!.measuredWidth / 1.5
        val offsetRate = offsetX.toFloat() * 0.25f / viewPager!!.measuredWidth
        val scaleFactor = 1 - Math.abs(offsetRate)

        if (scaleFactor > 0) {
            view.scaleX = scaleFactor
            view.scaleY = scaleFactor
            view.translationX = -maxTranslateOffsetX * offsetRate
            //ViewCompat.setElevation(view, 0.0f);
        }
        ViewCompat.setElevation(view, scaleFactor)

    }

    /**
     * Dp to pixel conversion
     */
    private fun dp2px(context: Context, dipValue: Float): Int {
        val m = context.resources.displayMetrics.density
        return (dipValue * m + 0.5f).toInt()
    }

}