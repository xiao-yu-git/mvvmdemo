package com.xiaoyu.mvvmdemo;

import android.app.Application;
import android.content.Context;

/**
 * XiaoYu
 * 2021/1/25 23:08
 */
public class DemoApplication extends Application {

    public static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
    }
}
