package com.newyorktimes.newsapp.repository

import com.newyorktimes.newsapp.data.remote.Api
import com.newyorktimes.newsapp.data.remote.response.ResponseListener
import com.newyorktimes.newsapp.model.User
import com.newyorktimes.newsapp.schedulers.SchedulerContract
import com.google.gson.JsonObject
import javax.inject.Inject

/****
 * User Repository which keeps all the service calls related to User entity
 * Author: Lajesh Dineshkumar
 * Created on: 11/4/19
 * Modified on: 11/4/19
 *****/
class UserRepository@Inject constructor(private val api: Api, scheduler: SchedulerContract)
    : BaseRepository(scheduler){

    /**
     * The method for performing the user login
     * @param authorizationHeader : Access Token
     * @param bodyParams: Json Body
     * @param responseListener: Response Listener Callback
     */
    fun login(authorizationHeader: String, bodyParams: JsonObject, responseListener: ResponseListener<User>) {
        performRequest(api.login(authorizationHeader, bodyParams), responseListener)
    }

}