package com.newyorktimes.newsapp.view.fragment.news

import com.newyorktimes.newsapp.BR
import com.newyorktimes.newsapp.R
import com.newyorktimes.newsapp.databinding.FragmentNewsListBinding
import com.newyorktimes.newsapp.view.fragment.base.BaseFragment

/****
 * Login Fragment
 * Author: Lajesh Dineshkumar
 * Created on: 11/4/19
 * Modified on: 11/4/19
 *****/
class NewsListFragment : BaseFragment<NewsListViewModel, FragmentNewsListBinding>() {
    override val layoutRes: Int
        get() = R.layout.fragment_news_list

    override val bindingVariable: Int
        get() = BR.viewModel

    override fun getViewModel(): Class<NewsListViewModel> {
        return NewsListViewModel::class.java
    }

    override fun getTitle(): String {
        return ""
    }
}