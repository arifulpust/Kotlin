package com.ariful.kotlinapp.requestHandler


/**
 * Created by bipulkhan on 4/3/17.
 */

object ApiUtils {

    val apiService: APIService
        get() = RetrofitClient.getClient("https://jsonplaceholder.typicode.com")!!.create(APIService::class.java)
}
