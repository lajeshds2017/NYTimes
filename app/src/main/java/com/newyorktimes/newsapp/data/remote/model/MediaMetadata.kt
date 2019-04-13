package com.newyorktimes.newsapp.data.remote.model

import com.google.gson.annotations.SerializedName

/****
 * Media Metadata class
 * Author: Lajesh Dineshkumar
 * Created on: 4/13/19
 * Modified on: 4/13/19
 *****/
data class MediaMetadata(@SerializedName("url") var imageUrl : String?,
                         @SerializedName("format") var format: String?) {
    init {
        imageUrl = ""
        format = ""
    }
}