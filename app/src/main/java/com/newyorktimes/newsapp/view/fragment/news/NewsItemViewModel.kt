package com.newyorktimes.newsapp.view.fragment.news

import android.databinding.ObservableField
import com.newyorktimes.newsapp.viewmodel.BaseViewModel

/****
 * News Item ViewModel
 * Author: Lajesh Dineshkumar
 * Created on: 4/13/19
 * Modified on: 4/13/19
 *****/
class NewsItemViewModel() : BaseViewModel() {

    var newsTitle =  ObservableField<String?>()
    var newsAuthors = ObservableField<String?>()
    var publishedDate = ObservableField<String?>()
    var newsUrl = ObservableField<String?>()
    var newsThumbnailUrl = ObservableField<String?>()


    constructor(title: String?, authors: String?, date: String?, url: String?, urlImage: String?) : this() {
        newsTitle.set(title)
        newsAuthors.set(authors)
        publishedDate.set(date)
        newsUrl.set(url)
        newsThumbnailUrl.set(urlImage)
    }

}