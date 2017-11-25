package com.ariful.kotlinapp.list

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.LinearLayout
import com.ariful.kotlinapp.R
import android.support.v7.widget.GridLayoutManager
import android.widget.ArrayAdapter
import android.widget.ListView


class RecyclearViewActivity : AppCompatActivity() {
    var listAdapter: ArrayAdapter<String>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_activity)

        val recyclerView = findViewById<View>(R.id.recyclerView) as RecyclerView
        val listview = findViewById<View>(R.id.listview) as ListView

        //mLayoutManager = GridLayoutManager(this, 3)
    //    recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.HORIZONTAL, false)
        recyclerView.layoutManager =GridLayoutManager(this, 3)

        val users = ArrayList<User>()
        users.add(User("Belal Khan", "Ranchi, India"))
        users.add(User("Belal Khan", "Ranchi, India"))
        users.add(User("Belal Khan", "Ranchi, India"))
        users.add(User("Belal Khan", "Ranchi, India"))
        users.add(User("Belal Khan", "Ranchi, India"))
        users.add(User("Belal Khan", "Ranchi, India"))
        users.add(User("Belal Khan", "Ranchi, India"))
        users.add(User("Belal Khan", "Ranchi, India"))
        users.add(User("Belal Khan", "Ranchi, India"))
        var adapter = CustomAdapter(users)
        recyclerView.adapter = adapter
//bilt in listview
//   var planets:List<String> = listOf("Mercury", "Venus", "Earth", "Mars","Jupiter", "Saturn", "Uranus", "Neptune")
//        // Create ArrayAdapter using the planet list.
//        listAdapter =  ArrayAdapter<String>(this, R.layout.simplerow, planets);
//
//        listview.setAdapter( listAdapter )

        var  adapter2 = ListAdapter(users, applicationContext)
        listview.adapter=adapter2

    }
}
