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

class MainActivity : AppCompatActivity() {
    lateinit var unbinder:Unbinder
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // unbinder= ButterKnife.bind(this)
        val simpleOperation = findViewById<Button>(R.id.simpleOperation)
        val JavaInKotlin = findViewById<Button>(R.id.JavaInKotlin)
        val pdfFile = findViewById<Button>(R.id.pdfFile)


        simpleOperation.setOnClickListener {
            val changePage = Intent(this, SimpleOperation::class.java)
            startActivity(changePage)
        }
        JavaInKotlin.setOnClickListener {
            val changePage = Intent(this, ButterKnifeTest::class.java)
            startActivity(changePage)
        }
        pdfFile.setOnClickListener {
            val changePage = Intent(this, CreateAndViewPdfFile::class.java)
            startActivity(changePage)
        }

    }


    override fun onDestroy() {
        super.onDestroy()
       // unbinder.unbind()

    }
}
