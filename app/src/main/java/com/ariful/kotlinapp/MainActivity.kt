package com.ariful.kotlinapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import butterknife.*

class MainActivity : AppCompatActivity() {
    var result:TextView?=null

    lateinit var unbinder:Unbinder
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // unbinder= ButterKnife.bind(this)
        val add = findViewById<Button>(R.id.Add)
        val first = findViewById<EditText>(R.id.first)
        val second = findViewById<EditText>(R.id.second)
        result = findViewById<TextView>(R.id.result)
        add.setOnClickListener {

            var Result: Int?=0
            Result=first.text.toString().trim().toInt()+second.text.toString().trim().toInt()
            result!!.text=Result.toString()+" fdeswfew"
          //  result.setText("\ndqwdeqw\n32r23")
            Toast.makeText(applicationContext,"result "+Result,Toast.LENGTH_LONG).show()
            Log.e("Result rr ",Result.toString()+"qq "+first.text.toString().trim().toInt())
            Log.e("Result rr ",Result.toString()+"qq "+first.text.toString().trim().toInt())
            Log.e("Result rr ",Result.toString()+"qq "+first.text.toString().trim().toInt())
            Log.e("Result rr ",Result.toString()+"qq "+first.text.toString().trim().toInt())
            Log.e("Result rr ",Result.toString()+"qq "+first.text.toString().trim().toInt())
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        unbinder.unbind()

    }
}
