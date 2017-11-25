package com.ariful.kotlinapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import butterknife.Unbinder

class ButterKnifeTest : AppCompatActivity() {
    @BindView(R.id.result)
    lateinit var result: TextView
    lateinit var unbinder:Unbinder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_butter_knife_test)
        unbinder= ButterKnife.bind(this)


    }

    @OnClick(R.id.click)
    fun Call() {

        result!!.text = "cdasbfcsdhfcbsdvc"
    }

    override fun onDestroy() {
        super.onDestroy()
        unbinder?.unbind()
    }
}
