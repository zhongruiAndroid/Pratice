package com.test.mvvm.vm;

import android.databinding.ViewDataBinding;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import com.test.mvvm.UserInfo;

/***
 *   created by zhongrui on 2019/9/21
 */
public class LoginViewModel {
    public UserInfo user;

    public LoginViewModel(ViewDataBinding dataBinding) {
        user=new UserInfo();
        user.name.set("test");
        user.pwd.set("123");
    }

    public TextWatcher nameWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            user.name.set(String.valueOf(s));
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
    public TextWatcher pwdWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            user.pwd.set(String.valueOf(s));
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    public View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String name = user.name.get();
            String pwd = user.pwd.get();
            if("test".endsWith(name)&&"123".endsWith(pwd)){
                Log.i("=====","=====登录成功=");
            }else{
                Log.i("=====",name+"=====登录失败="+pwd);
            }
        }
    };
}
