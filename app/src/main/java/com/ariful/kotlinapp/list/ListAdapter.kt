package com.ariful.kotlinapp.list

import android.content.Context
import android.support.v7.widget.CardView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

import com.ariful.kotlinapp.R

import java.util.ArrayList

/**
 * Created by Ariful Islam on 11/25/2017.
 */
class ListAdapter(private val dataSet: ArrayList<User>, internal var mContext: Context) : ArrayAdapter<User>(mContext, R.layout.list_layout, dataSet), View.OnClickListener {

    private var lastPosition = -1

    // View lookup cache
    private open class ViewHolder {
        internal var textViewName: TextView? = null
        internal var textViewAddress: TextView? = null
        internal var card: CardView? = null


    }

    override fun onClick(v: View) {

        val position = v.tag as Int
        val (name, address) = getItem(position)

        when (v.id) {
            R.id.card -> {
                //card
                Log.e("list item","call")
                 //  Snackbar.make(v, "Release date " +dataModel.getFeature(), Snackbar.LENGTH_LONG)
                // .setAction("No action", null).show();
            }
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        // Get the data item for this position
        val dataModel = getItem(position)
        // Check if an existing view is being reused, otherwise inflate the view
        val viewHolder: ViewHolder // view lookup cache stored in tag

        val result: View

        if (convertView == null) {

            viewHolder = ViewHolder()
            val inflater = LayoutInflater.from(context)
            convertView = inflater.inflate(R.layout.list_layout, parent, false)
            viewHolder.card = convertView!!.findViewById<View>(R.id.card) as CardView
            viewHolder.textViewAddress = convertView.findViewById<View>(R.id.textViewAddress) as TextView
            viewHolder.textViewName = convertView.findViewById<View>(R.id.textViewName) as TextView
            //viewHolder.info = (ImageView) convertView.findViewById(R.id.item_info);
            result = convertView
            convertView.tag = viewHolder
        } else {
            viewHolder = convertView.tag as ViewHolder
            result = convertView
        }
        //  Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        //  result.startAnimation(animation);
        lastPosition = position

        viewHolder.textViewAddress!!.text = dataModel!!.address
        viewHolder.textViewName!!.setText(dataModel!!.name)
        // viewHolder.txtVersion.setText(dataModel.getVersion_number());
        //   viewHolder.info.setOnClickListener(this);

        // Return the completed view to render on screen
        return convertView
    }
}