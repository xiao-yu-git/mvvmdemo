package com.xiaoyu.mvvmdemo;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

/**
 * XiaoYu
 * 2021/1/25 23:48
 */
public class UserEntity extends BaseObservable implements Parcelable {
    private String account;
    private String password;
    @Bindable
    private String nickname;
    private String headUrl;

    public UserEntity(String account, String password, String nickname, String headUrl) {
        this.account = account;
        this.password = password;
        this.nickname = nickname;
        this.headUrl = headUrl;
    }

    protected UserEntity(Parcel in) {
        account = in.readString();
        password = in.readString();
        nickname = in.readString();
        headUrl = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(account);
        dest.writeString(password);
        dest.writeString(nickname);
        dest.writeString(headUrl);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<UserEntity> CREATOR = new Creator<UserEntity>() {
        @Override
        public UserEntity createFromParcel(Parcel in) {
            return new UserEntity(in);
        }

        @Override
        public UserEntity[] newArray(int size) {
            return new UserEntity[size];
        }
    };

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
        notifyPropertyChanged(BR.nickname);
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }
}
