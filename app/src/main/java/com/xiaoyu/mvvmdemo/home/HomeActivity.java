package com.xiaoyu.mvvmdemo.home;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;

import com.xiaoyu.mvvmdemo.R;
import com.xiaoyu.mvvmdemo.databinding.ActivityHomeBinding;
import com.xiaoyu.mvvmdemo.login.LoginActivity;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        binding.setUserInfo(getIntent().getParcelableExtra("user"));

        binding.nicknameView.setOnClickListener(v -> showInputDialog());
        binding.logout.setOnClickListener(v -> {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        });
        ObservableBoolean isRefreshing = new ObservableBoolean(false);
        binding.setIsRefreshing(isRefreshing);
        binding.refreshButton.setOnClickListener(v->isRefreshing.set(!isRefreshing.get()));
    }

    private void showInputDialog() {
        final EditText editText = new EditText(this);
        AlertDialog.Builder inputDialog =
                new AlertDialog.Builder(this);
        inputDialog.setTitle("请输入您的新昵称").setView(editText);
        inputDialog.setPositiveButton("确定", (dialogInterface, i) -> {
            if (TextUtils.isEmpty(editText.getText())) {
                Toast.makeText(HomeActivity.this, "昵称不能为空", Toast.LENGTH_SHORT).show();
                return;
            }
            binding.getUserInfo().setNickname(editText.getText().toString());
        }).show();
    }
}