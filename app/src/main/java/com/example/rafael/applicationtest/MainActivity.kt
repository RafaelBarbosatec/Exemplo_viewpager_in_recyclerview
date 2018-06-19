package com.example.rafael.applicationtest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.rafael.applicationtest.adapters.MainAdapter
import com.example.rafael.applicationtest.model.Item
import com.example.rafael.applicationtest.model.SubItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerview.layoutManager = LinearLayoutManager(this)


        val list = ArrayList<Item>()
        val sublist = ArrayList<SubItem>()
        sublist.add(SubItem("subItem 1","https://u.tfstatic.com/restaurant_photos/658/69658/169/612/l-o-restaurante-marquise-3b9f9.jpg"))
        sublist.add(SubItem("subItem 2","https://u.tfstatic.com/restaurant_photos/658/69658/169/612/l-o-restaurante-marquise-3b9f9.jpg"))
        sublist.add(SubItem("subItem 3","https://u.tfstatic.com/restaurant_photos/658/69658/169/612/l-o-restaurante-marquise-3b9f9.jpg"))

        list.add(Item("Item 1",sublist))

        val sublist2 = ArrayList<SubItem>()
        sublist2.add(SubItem("subItem 1","https://img.stpu.com.br/?img=https://s3.amazonaws.com/pu-mgr/default/a0R0f00000wL8neEAC/5977a37fe4b00ce12c83b4ed.jpg&w=620&h=400"))
        sublist2.add(SubItem("subItem 2","https://img.stpu.com.br/?img=https://s3.amazonaws.com/pu-mgr/default/a0R0f00000wL8neEAC/5977a37fe4b00ce12c83b4ed.jpg&w=620&h=400"))
        sublist2.add(SubItem("subItem 3","https://img.stpu.com.br/?img=https://s3.amazonaws.com/pu-mgr/default/a0R0f00000wL8neEAC/5977a37fe4b00ce12c83b4ed.jpg&w=620&h=400"))

        list.add(Item("Item 2",sublist2))

        val sublist3 = ArrayList<SubItem>()
        sublist3.add(SubItem("subItem 1","http://rivieradesaolourenco.com/wp-content/uploads/2012/05/jeriqua.jpg"))
        sublist3.add(SubItem("subItem 2","http://rivieradesaolourenco.com/wp-content/uploads/2012/05/jeriqua.jpg"))
        sublist3.add(SubItem("subItem 3","http://rivieradesaolourenco.com/wp-content/uploads/2012/05/jeriqua.jpg"))


        list.add(Item("Item 3",sublist3))

        val adaper = MainAdapter(list,this)

        recyclerview.adapter = adaper
    }
}
