package com.newyorktimes.newsapp.listeners

import com.newyorktimes.newsapp.view.fragment.news.NewsItemViewModel

/****
 * News List item click listener
 * Author: Lajesh Dineshkumar
 * Created on: 4/13/19
 * Modified on: 4/13/19
 *****/
interface OnItemClickListener {
    fun onItemClick(item: NewsItemViewModel)
}