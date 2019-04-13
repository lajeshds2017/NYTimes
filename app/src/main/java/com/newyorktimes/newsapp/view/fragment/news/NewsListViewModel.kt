package com.newyorktimes.newsapp.view.fragment.news

import com.newyorktimes.newsapp.data.remote.model.NewsListResponse
import com.newyorktimes.newsapp.data.remote.response.ApiResponse
import com.newyorktimes.newsapp.data.remote.response.ResponseListener
import com.newyorktimes.newsapp.model.User
import com.newyorktimes.newsapp.repository.NewsRepository
import com.newyorktimes.newsapp.viewmodel.BaseViewModel
import javax.inject.Inject

/****
 * The presentation layer of Login fragment
 * Author: Lajesh Dineshkumar
 * Created on: 11/4/19
 * Modified on: 11/4/19
 *****/
class NewsListViewModel @Inject constructor(private val newsRepository: NewsRepository) : BaseViewModel<User>(){


    /**
     * Service call that performs the user login
     */
    fun loadNews(){
        newsRepository.getNews(1, object :ResponseListener<NewsListResponse>{
            override fun onStart() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onFinish() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(result: ApiResponse<NewsListResponse>) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
    }


}