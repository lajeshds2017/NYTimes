package com.newyorktimes.newsapp.view.fragment.login

import android.arch.lifecycle.MutableLiveData
import com.newyorktimes.newsapp.common.JsonKeyConstants
import com.newyorktimes.newsapp.data.remote.response.ApiResponse
import com.newyorktimes.newsapp.data.remote.response.ResponseListener
import com.newyorktimes.newsapp.model.User
import com.newyorktimes.newsapp.repository.UserRepository
import com.newyorktimes.newsapp.viewmodel.BaseViewModel
import com.google.gson.JsonObject
import javax.inject.Inject

/****
 * The presentation layer of Login fragment
 * Author: Lajesh Dineshkumar
 * Created on: 11/4/19
 * Modified on: 11/4/19
 *****/
class LoginViewModel @Inject constructor(private val userRepository: UserRepository) : BaseViewModel<User>(){

    val userName =  MutableLiveData<String>()
    val password = MutableLiveData<String>()

    /**
     * Service call that performs the user login
     */
    fun doLogin(){
        userRepository.login("", constructBodyParamsForLogin(), object :ResponseListener<User>{
            override fun onStart() {
                loadingStatus.value = true
            }

            override fun onFinish() {
                loadingStatus.value = true
            }

            override fun onResponse(result: ApiResponse<User>) {
                response.value = result
            }

        } )
    }

    /**
     * This method return the JSON body for Login service call
     */
    fun constructBodyParamsForLogin() : JsonObject{
        val jsonObject = JsonObject();
        jsonObject.addProperty(JsonKeyConstants.JSON_KEY_USERNAME, userName.value)
        jsonObject.addProperty(JsonKeyConstants.JSON_KEY_PASSWORD, password.value)
        return jsonObject
    }

}