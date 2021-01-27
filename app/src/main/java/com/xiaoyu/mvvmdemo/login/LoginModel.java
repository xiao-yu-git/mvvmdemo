package com.xiaoyu.mvvmdemo.login;

import com.xiaoyu.mvvmdemo.ResultCallback;
import com.xiaoyu.mvvmdemo.UserEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * XiaoYu
 * 2021/1/25 23:15
 */
public class LoginModel {

    private final Map<String, UserEntity> accounts = new HashMap<>();

    private final ResultCallback<UserEntity> resultCallback;

    public LoginModel(ResultCallback<UserEntity> resultCallback) {
        this.resultCallback = resultCallback;
        accounts.put("1", new UserEntity("1","1","用户1","https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fi0.hdslb.com%2Fbfs%2Farticle%2F69222434a5868206bb49e852818cb9ef9eba4745.jpg&refer=http%3A%2F%2Fi0.hdslb.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1614182537&t=3773dab9aacef599497ddc9c3450c352"));
        accounts.put("2", new UserEntity("2","2","用户2","https://gimg2.baidu.com/image_search/src=http%3A%2F%2Finews.gtimg.com%2Fnewsapp_bt%2F0%2F11408698714%2F1000.jpg&refer=http%3A%2F%2Finews.gtimg.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1614182537&t=49a095022bc6914e55b6f1ff7882102a"));
        accounts.put("3", new UserEntity("3","3","用户3","https://pic.rmb.bdstatic.com/4c734ee087d30c91a38812c2028d50ef.jpeg"));
    }

    public void login(String account, String password) {
        new Thread(){
            @Override
            public void run() {
                //睡眠2s 模拟网络请求
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (accounts.containsKey(account)) {
                    if (password.equals(accounts.get(account).getPassword())) {
                        resultCallback.onSuccess(accounts.get(account));
                    } else {
                        resultCallback.onError("密码错误");
                    }
                } else {
                    resultCallback.onError("账号错误");
                }
            }
        }.start();
    }
}
