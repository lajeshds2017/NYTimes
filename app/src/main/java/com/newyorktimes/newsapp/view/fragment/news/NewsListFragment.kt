package com.newyorktimes.newsapp.view.fragment.news

import android.arch.lifecycle.Observer
import android.net.Uri
import android.os.Bundle
import android.support.customtabs.CustomTabsIntent
import android.support.v4.content.ContextCompat
import android.view.View
import com.newyorktimes.newsapp.BR
import com.newyorktimes.newsapp.R
import com.newyorktimes.newsapp.databinding.FragmentNewsListBinding
import com.newyorktimes.newsapp.view.fragment.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_news_list.*


/****
 * News List fragment
 * Author: Lajesh Dineshkumar
 * Created on: 11/4/19
 * Modified on: 11/4/19
 *****/
class NewsListFragment : BaseFragment<NewsListViewModel, FragmentNewsListBinding>() {

    override fun getTitle(): String {
        return getString(R.string.app_name)
    }

    override val layoutRes: Int
        get() = R.layout.fragment_news_list

    override val bindingVariable: Int
        get() = BR.viewModel

    override fun getViewModel(): Class<NewsListViewModel> {
        return NewsListViewModel::class.java
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadNews()
    }

    override fun observeNavigationEvent() {
        super.observeNavigationEvent()
        viewModel.navigateToDetails.observe(this, android.arch.lifecycle.Observer {
            it?.let {
                navigateToDetails(it)
            }

        })
    }

    override fun observeServiceError() {
        super.observeServiceError()
        viewModel.serviceErrorEvent.observe(this, Observer {
            it?.let{
                showErrorDialog(it)
                empty_view.visibility = View.VISIBLE;
            }
        })
    }

    fun navigateToDetails(url: String?) {
        val builder = CustomTabsIntent.Builder()
        activity?.let {
            builder.setToolbarColor(ContextCompat.getColor(activity!!, R.color.colorPrimary))
            builder.setStartAnimations(activity!!, R.anim.anim_enter, R.anim.anim_exit)
            //builder.setExitAnimations(activity!!, R.anim.anim_pop_enter, R.anim.anim_pop_enter)
        }

        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(activity, Uri.parse(url))
    }


}