package com.ariful.kotlinapp

import android.app.Application
import butterknife.ButterKnife

/**
 * Created by Ariful Islam on 11/24/2017.
 */
class SimpleApp : Application() {
    override fun onCreate() {
        super.onCreate()
        ButterKnife.setDebug(BuildConfig.DEBUG)
    }
}