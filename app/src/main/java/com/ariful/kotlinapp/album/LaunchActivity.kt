package com.ariful.kotlinapp.album

import android.app.ProgressDialog
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
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LaunchActivity : AppCompatActivity(){

    private val TAG: String = javaClass.simpleName
//@BindView(R.id.recyclerView)
//lateinit
    var pDialog:ProgressDialog?=null
 var  recyclerView:  RecyclerView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)
        recyclerView = findViewById<View>(R.id.list_album) as RecyclerView
        recyclerView?.layoutManager =GridLayoutManager(this, 2)

        getRequest()
    }

fun getRequest()
{
  var request=  ApiClient.apiInterface;
    //showProgressBar()
    val d = object : DisposableSubscriber<List<Image>>() {
        override fun onNext(album: List<Image>) {

            val gson = Gson()
            Log.e("album Status", "" + gson.toJson(album))

            Log.e("response.body()",""+album.size+"  "+album.get(1).title)
            var adapter   =  ImageAdapter(applicationContext,album)
            // recyclerView?.setAdapter( adapter )
            recyclerView?.adapter = adapter
        }

        override fun onError(e: Throwable) {


            Log.e("On Error", "error--- "+e.message)
            e.printStackTrace()
        }

        override fun onComplete() {
      //      hideProgressBar()
            Log.e("Model", "onCompleted")
        }
    }

    request.getImageData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(d)
}

    fun showProgressBar() {
        Progressdialog()
        pDialog!!.show()
    }

    fun hideProgressBar() {

        if(pDialog!=null)
        pDialog!!.dismiss()
    }

    fun Progressdialog() {
        if (pDialog == null) {
            pDialog = ProgressDialog(LaunchActivity())
            pDialog!!.setMessage("Sending data...")
            pDialog!!.setIndeterminate(false)
            pDialog!!.setCancelable(true)
        }

    }
}
