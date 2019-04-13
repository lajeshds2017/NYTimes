package com.newyorktimes.newsapp.data.remote.model

import com.google.gson.annotations.SerializedName

/****
 * Data Model class which represents the list of news
 * Author: Lajesh Dineshkumar
 * Company: Farabi Technologies
 * Created on: 4/13/19
 * Modified on: 4/13/19
 *****/
data class NewsListResponse(@SerializedName("results") var popularNewsList : ArrayList<String>?) {
    init {
        popularNewsList = ArrayList()
    }

}