package com.newyorktimes.newsapp.view.listeners

/****
 * Back press listener for handling back navigation in activity/fragments
 * Author: Lajesh Dineshkumar
 * Created on: 11/4/19
 * Modified on: 11/4/19
 *****/
interface BackPressListener {
    fun onBackPress(): Boolean
}