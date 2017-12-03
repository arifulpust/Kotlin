package com.ariful.kotlinapp.retrofit

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.View

import com.ariful.kotlinapp.R
import com.ariful.kotlinapp.requestHandler.APIService
import com.ariful.kotlinapp.requestHandler.ApiUtils
import com.google.gson.Gson

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber

class RetrofitTest : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit_test)

        Request()

    }

    fun Request() {
        val mAPIService = ApiUtils.apiService
        val d = object : DisposableSubscriber<List<Model>>() {
            override fun onNext(jsonObject: List<Model>) {
                Log.e("On jsonObject", "--- " + Gson().toJson(jsonObject)+"\n"+jsonObject.get(0).title)
            }

            override fun onError(e: Throwable) {

                Log.e("On Error", "error--- ")
                e.printStackTrace()
            }

            override fun onComplete() {

                Log.e("Model", "onCompleted")
            }
        }

        mAPIService.data
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(d)
    }
}
