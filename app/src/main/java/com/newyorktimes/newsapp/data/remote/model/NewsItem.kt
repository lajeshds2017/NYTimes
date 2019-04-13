package com.newyorktimes.newsapp.data.remote.model

import com.google.gson.annotations.SerializedName

/****
 * Data model representing a single news item
 * Author: Lajesh Dineshkumar
 * Created on: 4/13/19
 * Modified on: 4/13/19
 *****/
data class NewsItem (@SerializedName("id") var id: Long?,
                     @SerializedName("title") var title: String?,
                     @SerializedName("byline") var authors: String?,
                     @SerializedName("published_date") var publishedDate: String?,
                     @SerializedName("url") var url: String?,
                     @SerializedName("media") var media: ArrayList<Media>?){
    init {
        id = 0
        title = ""
        authors = ""
        publishedDate = ""
        url = ""
        media = ArrayList()
    }
}