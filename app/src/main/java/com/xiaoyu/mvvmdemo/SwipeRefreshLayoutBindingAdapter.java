package com.xiaoyu.mvvmdemo;

import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.InverseBindingListener;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class SwipeRefreshLayoutBindingAdapter {

    @BindingAdapter("bindIsRefreshing")
    public static void setRefreshing(SwipeRefreshLayout refreshLayout, boolean isRefreshing) {
        if (refreshLayout.isRefreshing() != isRefreshing) {
            refreshLayout.setRefreshing(isRefreshing);
        }
    }

    @InverseBindingAdapter(attribute = "bindIsRefreshing", event = "onRefreshChange")
    public static boolean isRefreshing(SwipeRefreshLayout refreshLayout) {
        return refreshLayout.isRefreshing();
    }

    @BindingAdapter("onRefreshChange")
    public static void setOnRefreshListener(SwipeRefreshLayout refreshLayout, InverseBindingListener inverseBindingListener) {
        refreshLayout.setOnRefreshListener(inverseBindingListener::onChange);
    }
}