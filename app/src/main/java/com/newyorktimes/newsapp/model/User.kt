package com.newyorktimes.newsapp.model

import com.google.gson.annotations.SerializedName

/****
 * This class represnets the user data model
 * Author: Lajesh Dineshkumar
 * Created on: 11/4/19
 * Modified on: 11/4/19
 *****/
data class User (@SerializedName("username") var username: String,
                 @SerializedName("password") var password: String,
                 @SerializedName("fullname") var fullName: String,
                 @SerializedName("token") var authToken : String){
    init {
        username = ""
        password = ""
        fullName = ""
        authToken = ""
    }
}