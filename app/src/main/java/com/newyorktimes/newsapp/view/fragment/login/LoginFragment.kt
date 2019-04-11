package com.newyorktimes.newsapp.view.fragment.login

import com.newyorktimes.newsapp.BR
import com.newyorktimes.newsapp.R
import com.newyorktimes.newsapp.databinding.FragmentLoginBinding
import com.newyorktimes.newsapp.view.fragment.base.BaseFragment

/****
 * Login Fragment
 * Author: Lajesh Dineshkumar
 * Created on: 11/4/19
 * Modified on: 11/4/19
 *****/
class LoginFragment : BaseFragment<LoginViewModel, FragmentLoginBinding>() {
    override val layoutRes: Int
        get() = R.layout.fragment_login

    override val bindingVariable: Int
        get() = BR.viewModel

    override fun getViewModel(): Class<LoginViewModel> {
        return LoginViewModel::class.java
    }

    override fun getTitle(): String {
        return ""
    }
}