package com.newyorktimes.newsapp.data.remote.response

import com.google.gson.annotations.SerializedName

/****
 * Data Model class which represents the error response
 * Author: Lajesh Dineshkumar
 * Created on: 11/4/19
 * Modified on: 11/4/19
 *****/
data class ErrorResponse (@SerializedName("errorCode") var errorCode:  String,
                          @SerializedName("errorDescription") var errorDescription: String){
    init {
        errorCode = ""
        errorDescription = ""
    }
}