package com.xiaoyu.mvvmdemo;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

/**
 * XiaoYu
 * 2021/1/25 23:53
 */
public class ImageViewBindingAdapter {

    @BindingAdapter(value = {"bindUrl", "bindPlaceholder"}, requireAll = false)
    public static void bindUrlAndPlaceholder(ImageView view, String url, int placeholder) {
        Glide.with(view).load(url).apply(new RequestOptions().placeholder(placeholder)).into(view);
    }
}
