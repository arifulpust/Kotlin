package com.ariful.kotlinapp.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ariful.kotlinapp.R

/**
 * Created by Belal on 6/23/2017.
 */


class CustomAdapter(val userList: ArrayList<User>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder?, p1: Int) {
        val user: User = userList[p1]
        holder?.textViewName?.text = user.name
        holder?.textViewAddress?.text = user.address
    }

    override fun onCreateViewHolder(holder: ViewGroup?, p1: Int): ViewHolder {
        val v = LayoutInflater.from(holder?.context).inflate(R.layout.list_layout, holder, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return userList.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textViewName = itemView.findViewById<View>(R.id.textViewName) as TextView
        val textViewAddress = itemView.findViewById<View>(R.id.textViewAddress) as TextView
    }
}