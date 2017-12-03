package com.ariful.kotlinapp.album


import com.github.aurae.retrofit2.LoganSquareConverterFactory
import retrofit2.Retrofit


object ApiClient {

    val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(LoganSquareConverterFactory.create())
            .build()
    val apiInterface: ApiInterface

    init {
        apiInterface = retrofit.create(ApiInterface::class.java)
    }
}
