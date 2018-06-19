package com.example.rafael.applicationtest.adapters

import android.support.v7.widget.RecyclerView
import com.example.rafael.applicationtest.model.Item
import android.view.View
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import br.com.ipiranga.abasteceai.Support.View.CarouselEffectTransformer
import com.example.rafael.applicationtest.R
import com.example.rafael.applicationtest.util.Functions
import kotlinx.android.synthetic.main.item_main.view.*


class MainAdapter(var mlista: ArrayList<Item>,
                  val context: Context) : RecyclerView.Adapter<MainAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false)

        return MyViewHolder(view)

    }

    override fun getItemCount(): Int {

        return mlista.size

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val item = mlista[position]

        holder.itemView.textview_nome.text = item.name

        val adapter = SubItemAdapter(context,item.list)

        holder.itemView.viewpager.clipToPadding = false
        holder.itemView.viewpager.setPadding(Functions.dp2px(context,16f), 0, Functions.dp2px(context,16f), 0)
        holder.itemView.viewpager.offscreenPageLimit = 3
        holder.itemView.viewpager.setPageTransformer(false,CarouselEffectTransformer(context))
        holder.itemView.viewpager.adapter = adapter

    }


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)
}