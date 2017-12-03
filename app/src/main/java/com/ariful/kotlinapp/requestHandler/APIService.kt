package com.ariful.kotlinapp.requestHandler

import com.ariful.kotlinapp.retrofit.Model


import io.reactivex.Flowable
import io.reactivex.Observable
import okhttp3.MultipartBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by bipulkhan on 4/3/17.
 */

interface APIService {

    //    @Headers({
    //            "Accept: application/json"
    //    })
    //    @POST("oauth/token?")
    //    Observable<LoginObj> savePost(@Header("Authorization") String token, @Query("grant_type") String type, @Query("username") String user, @Query("password") String pass);
    //
    //    //http://192.168.0.104:8080/FmcgAPI/oauth/token?grant_type=password&username=admin&password=123
    //    @Headers({
    //            "Accept: application/json",
    //            "Content-Type: application/json"
    //    })
    //    @POST("restrole/userLogout/?")
    //    Flowable<LoginMessage> Logout(@Query("access_token") String accessToken, @Body UserLogoutObject obj);
    //
    @get:Headers("Accept: application/json")
    @get:GET("/photos")
    val data: Flowable<List<Model>>


}