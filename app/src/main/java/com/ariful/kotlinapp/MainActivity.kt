package com.ariful.kotlinapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import butterknife.*
import com.ariful.kotlinapp.album.LaunchActivity
import com.ariful.kotlinapp.list.RecyclearViewActivity


class MainActivity : AppCompatActivity() {
    lateinit var unbinder:Unbinder
    @BindView(R.id.simpleOperation)
    lateinit var simpleOperation: Button
    @BindView(R.id.JavaInKotlin)
    lateinit var JavaInKotlin: Button
    @BindView(R.id.pdfFile)
    lateinit var pdfFile: Button
    @BindView(R.id.recyclearView)
    lateinit var recyclearView: Button
    @BindView(R.id.Retrofit)
    lateinit var Retrofit: Button
    //Retrofit
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
ButterKnife.bind(this)
        simpleOperation?.setOnClickListener {
            val changePage = Intent(this, SimpleOperation::class.java)
            startActivity(changePage)
        }
        JavaInKotlin?.setOnClickListener {
            val changePage = Intent(this, ButterKnifeTest::class.java)
            startActivity(changePage)
        }
        pdfFile?.setOnClickListener {
            val changePage = Intent(this, CreateAndViewPdfFile::class.java)
            startActivity(changePage)
        }
        recyclearView?.setOnClickListener {
            val changePage = Intent(this, RecyclearViewActivity::class.java)
            startActivity(changePage)
        }
        Retrofit?.setOnClickListener {
            val changePage = Intent(this, LaunchActivity::class.java)
            startActivity(changePage)
        }
        //LaunchActivity

    }


    override fun onDestroy() {
        super.onDestroy()
        unbinder.unbind()

    }
}
