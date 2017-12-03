package com.ariful.kotlinapp.album

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Ariful Islam on 12/3/2017.
 */
 class Image{
    var id: Int = 0
    var albumId: Int = 0
    var title: String?=null
    var url: String?=null
    var thumbnailUrl: String?=null
}