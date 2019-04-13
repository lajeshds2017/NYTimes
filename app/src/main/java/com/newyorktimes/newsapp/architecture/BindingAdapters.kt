package com.newyorktimes.newsapp.architecture

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide

/****
 * Keep all static binding adapters here
 * Author: Lajesh Dineshkumar
 * Created on: 4/13/19
 * Modified on: 4/13/19
 *****/
object BindingAdapters {
    @JvmStatic
    @BindingAdapter("bind:imageUrl")
    fun loadImage(view: ImageView, url: String) {
        Glide.with(view.getContext()).load(url)
            .override(150, 150)
            .centerCrop()
            .into(view)
    }
}