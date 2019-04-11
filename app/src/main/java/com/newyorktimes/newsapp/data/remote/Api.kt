package com.newyorktimes.newsapp.data.remote

import com.newyorktimes.newsapp.model.User
import com.google.gson.JsonObject
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

/****
 * Keep all the REST Apis here
 * Author: Lajesh Dineshkumar
 * Created on: 11/4/19
 * Modified on: 11/4/19
 *****/
interface Api {
    @POST("user/login")
    fun login(@Header("Authorization") authorization: String, @Body params: JsonObject): Observable<User>

}