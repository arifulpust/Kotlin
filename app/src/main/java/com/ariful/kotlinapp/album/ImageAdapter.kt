package com.ariful.kotlinapp.album

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.ariful.kotlinapp.R
import com.ariful.kotlinapp.list.CustomAdapter
import com.ariful.kotlinapp.list.User
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

/**
 * Created by Dream71 on 03/12/2017.
 */

class ImageAdapter(var context:  Context, val userList: List<Image>) : RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder?, p1: Int) {
        val user: Image = userList[p1]

        Log.e("user",""+user.title+" "+user.thumbnailUrl);
        //holder?.photoThumbnail?.text = user.name
        holder?.photoTitle?.text = user.title
        Glide.with(context).load(user.url)
                .thumbnail(0.5f)
                .error(R.drawable.ic_photo_black_24px)
                // .placeholder(R.drawable.app_icon)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(  holder?.photoThumbnail)
    }

    override fun onCreateViewHolder(holder: ViewGroup?, p1: Int): ViewHolder {
        val v = LayoutInflater.from(holder?.context).inflate(R.layout.inflater_album_item, holder, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return userList.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val photoThumbnail = itemView.findViewById<View>(R.id.image_photo_thumbnail) as ImageView
        val photoTitle = itemView.findViewById<View>(R.id.text_photo_title) as TextView
    }
}