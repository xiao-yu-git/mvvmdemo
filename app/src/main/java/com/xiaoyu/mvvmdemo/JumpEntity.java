package com.xiaoyu.mvvmdemo;

import android.app.Activity;
import android.os.Bundle;

/**
 * XiaoYu
 * 2021/1/26 00:08
 */
public class JumpEntity {
    private final Class<? extends Activity> toActivity;

    private final Bundle bundle;

    public JumpEntity(Class<? extends Activity> toActivity, Bundle bundle) {
        this.toActivity = toActivity;
        this.bundle = bundle;
    }

    public Class<? extends Activity> getToActivity() {
        return toActivity;
    }

    public Bundle getBundle() {
        return bundle;
    }
}
