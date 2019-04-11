package com.newyorktimes.newsapp.view.activity

import com.newyorktimes.newsapp.BR
import com.newyorktimes.newsapp.R
import com.newyorktimes.newsapp.databinding.ActivityMainBinding
import com.newyorktimes.newsapp.view.activity.base.BaseActivity
import com.newyorktimes.newsapp.view.fragment.login.LoginViewModel


/****
 * MainActivity class
 * Author: Lajesh Dineshkumar
 * Created on: 11/4/19
 * Modified on: 11/4/19
 *****/
class MainActivity : BaseActivity<LoginViewModel, ActivityMainBinding>() {
    override val layoutRes: Int
        get() = R.layout.activity_main

    override val bindingVariable: Int
        get() = BR.viewModel

    override fun getViewModel(): Class<LoginViewModel> {
      return LoginViewModel::class.java
    }


}
