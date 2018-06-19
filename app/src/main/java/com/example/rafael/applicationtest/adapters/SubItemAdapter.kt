package com.example.rafael.applicationtest.adapters

import android.support.v4.view.PagerAdapter
import com.example.rafael.applicationtest.model.SubItem
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.rafael.applicationtest.R

class SubItemAdapter(var context: Context, var list: ArrayList<SubItem>) : PagerAdapter(){

    private val inflater : LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view?.equals(`object`)!!
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {

        container.removeView(`object` as View?)
    }


    override fun getCount(): Int {

        return list.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val view = inflater.inflate(R.layout.item_subitem, null)

        val item = list[position]

        val imageView = view.findViewById<ImageView>(R.id.imageview_subitem)

        Glide.with(context)
                .load(item.img)
                .centerCrop()
                .crossFade()
                .into(imageView)

        val textview = view.findViewById<TextView>(R.id.textview_subitem)

        textview.text = item.nome

        container.addView(view)

        return view
    }


}