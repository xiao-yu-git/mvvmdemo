package com.xiaoyu.mvvmdemo.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.xiaoyu.mvvmdemo.R;
import com.xiaoyu.mvvmdemo.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {


    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //创建DataBinding 对象
        ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        //创建VieModel
        LoginViewModel loginViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(LoginViewModel.class);

        binding.setLoginViewModel(loginViewModel);

        //普通写法
        /*loginViewModel.getLoading().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean showLoading) {
                if (showLoading) {
                    showLoading();
                } else {
                    dismissLoading();
                }
            }
        });*/
        //lambda 表达式
        //监听是否需要显示Loading
        loginViewModel.getLoading().observe(this, showLoading -> {
            if (showLoading) {
                showLoading();
            } else {
                dismissLoading();
            }
        });
        //监听需要跳转的地方
        loginViewModel.getJumpPage().observe(this, jump -> {
            Intent intent = new Intent(this, jump.getToActivity());
            intent.putExtras(jump.getBundle());
            startActivity(intent);
            finish();
        });

        //普通写法
//        loginViewModel.getToast().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(String s) {
//                toast(s);
//            }
//        });
        //lambda 表达式
        loginViewModel.getToast().observe(this,this::toast);
    }

    private void showLoading() {
        dialog = new ProgressDialog(this);
        dialog.setMessage("登陆中...");
        dialog.show();
    }

    private void dismissLoading() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    private void toast(String toast) {
        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
    }
}
