package com.ariful.kotlinapp.album

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.Toast
import butterknife.BindView
import com.ariful.kotlinapp.R
import com.ariful.kotlinapp.list.CustomAdapter

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LaunchActivity : AppCompatActivity(), Callback<List<AlbumDto>> {

    private val TAG: String = javaClass.simpleName
//@BindView(R.id.recyclerView)
//lateinit
public var  recyclerView:  RecyclerView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)
    //  var  photoListView = findViewById<View>(R.id.list_album) as RecyclerView
      //  photoListView!!.layoutManager = GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false)
        recyclerView = findViewById<View>(R.id.list_album) as RecyclerView
        recyclerView?.layoutManager =GridLayoutManager(this, 3)
        ApiClient.apiInterface.getAlbum().enqueue(this)

    }


    override fun onResponse(call: Call<List<AlbumDto>>?, response: Response<List<AlbumDto>>?) {
        if (response!!.isSuccessful && response.body() != null) {


            //photoListView?.adapter = AlbumAdapter(response.body() as List<AlbumDto>)
            var list:List<AlbumDto>?=null
            list=response.body();
            Log.e("response.body()",""+response.body().toList().size+"  "+list.toList().get(1).title)
            var adapter   =  ImageAdapter(applicationContext,response.body().toList())
           // recyclerView?.setAdapter( adapter )
            recyclerView?.adapter = adapter
        }
    }

    override fun onFailure(call: Call<List<AlbumDto>>?, t: Throwable?) {
        Toast.makeText(this, "Something went wrong!", Toast.LENGTH_SHORT).show()
    }
}
