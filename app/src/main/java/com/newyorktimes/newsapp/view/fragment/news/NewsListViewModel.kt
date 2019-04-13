package com.newyorktimes.newsapp.view.fragment.news

import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import com.newyorktimes.newsapp.BR
import com.newyorktimes.newsapp.R
import com.newyorktimes.newsapp.architecture.SingleLiveEvent
import com.newyorktimes.newsapp.data.remote.model.NewsListResponse
import com.newyorktimes.newsapp.data.remote.response.ApiResponse
import com.newyorktimes.newsapp.data.remote.response.ResponseListener
import com.newyorktimes.newsapp.listeners.OnItemClickListener
import com.newyorktimes.newsapp.model.User
import com.newyorktimes.newsapp.repository.NewsRepository
import com.newyorktimes.newsapp.viewmodel.BaseViewModel
import me.tatarka.bindingcollectionadapter2.ItemBinding
import javax.inject.Inject

/****
 * The presentation layer of Login fragment
 * Author: Lajesh Dineshkumar
 * Created on: 11/4/19
 * Modified on: 11/4/19
 *****/
class NewsListViewModel @Inject constructor(private val newsRepository: NewsRepository) : BaseViewModel(){

    val navigateToDetails =  SingleLiveEvent<String?>()

    /**
     * The Menu Item list.
     */
    val items: ObservableList<NewsItemViewModel> = ObservableArrayList<NewsItemViewModel>()

    /**
     * The Single item.
     */
    val itemBinding = ItemBinding.of<NewsItemViewModel> { itemBinding, position, item ->
        itemBinding.set(BR.itemViewModel, R.layout.item_news)
        itemBinding.bindExtra(BR.itemClickListener, object : OnItemClickListener {
            override fun onItemClick(item: NewsItemViewModel) {
                navigateToDetails.value = item.newsUrl.value
            }
        })
    }

    /**
     * Service call that performs the user login
     */
    fun loadNews(){
        newsRepository.getNews(1, object :ResponseListener<NewsListResponse>{
            override fun onStart() {
                loadingStatus.value = true
            }

            override fun onFinish() {
                loadingStatus.value = false
            }

            override fun onResponse(result: ApiResponse<NewsListResponse>) {
                if(result.error == null && null != result.data){
                    prepareNewsList(result.data)
                }else{
                    serviceErrorEvent.value = result.errorDescription
                }
            }

        })
    }

    fun prepareNewsList(newsListResponse: NewsListResponse) {

        var newsItems = newsListResponse.popularNewsList?.let { it } ?: return
        items.clear()
        for (newsItem in newsItems) {
            items.add(NewsItemViewModel(newsItem.title, newsItem.authors,
                newsItem.publishedDate, newsItem.url, newsItem.media!![0].mediaMetadata!![0].imageUrl))
        }


    }




}