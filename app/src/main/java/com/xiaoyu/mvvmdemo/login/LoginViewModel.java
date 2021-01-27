package com.xiaoyu.mvvmdemo.login;

import android.os.Bundle;

import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.xiaoyu.mvvmdemo.JumpEntity;
import com.xiaoyu.mvvmdemo.ResultCallback;
import com.xiaoyu.mvvmdemo.UserEntity;
import com.xiaoyu.mvvmdemo.home.HomeActivity;

/**
 * XiaoYu
 * 2021/1/25 22:43
 * 登陆ViewModel
 */
public class LoginViewModel extends ViewModel implements ResultCallback<UserEntity> {

    //登陆Model
    private final LoginModel loginModel = new LoginModel(this);

    //账号
    private final ObservableField<String> accountNumber = new ObservableField<>();

    //密码
    private final ObservableField<String> password = new ObservableField<>();

    //显示Loading
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();

    //显示Toast
    private final MutableLiveData<String> toast = new MutableLiveData<>();

    //跳转到某页
    private final MutableLiveData<JumpEntity> jumpPage = new MutableLiveData<>();

    public MutableLiveData<String> getToast() {
        return toast;
    }

    public MutableLiveData<JumpEntity> getJumpPage() {
        return jumpPage;
    }

    public MutableLiveData<Boolean> getLoading() {
        return loading;
    }

    public ObservableField<String> getAccountNumber() {
        return accountNumber;
    }

    public ObservableField<String> getPassword() {
        return password;
    }

    public void login() {
        getLoading().postValue(true);
        loginModel.login(accountNumber.get(), password.get());
    }

    @Override
    public void onSuccess(UserEntity userEntity) {
        //跳转到成功的Activity
        getLoading().postValue(false);
        Bundle bundle = new Bundle();
        bundle.putParcelable("user", userEntity);
        getJumpPage().postValue(new JumpEntity(HomeActivity.class, bundle));
    }

    @Override
    public void onError(String errorMessage) {
        getLoading().postValue(false);
        getToast().postValue(errorMessage);
    }
}
