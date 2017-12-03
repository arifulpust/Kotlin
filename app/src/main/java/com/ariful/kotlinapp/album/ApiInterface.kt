package com.ariful.kotlinapp.album


import io.reactivex.Flowable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

/**
 * Created by Guru karthik on 10-06-2017.
 */

interface ApiInterface {
//    @GET("/photos")
//    fun getAlbum(): Call<List<AlbumDto>>

    @Headers("Accept: application/json")
    @GET("/photos")
     fun getImageData(): Flowable<List<Image>>
}
