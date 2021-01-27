package com.xiaoyu.mvvmdemo;

/**
 * XiaoYu
 * 2021/1/25 23:15
 */
public interface ResultCallback<T> {
    void onSuccess(T t);

    void onError(String errorMessage);
}
