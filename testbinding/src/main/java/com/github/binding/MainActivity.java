package com.github.binding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.github.binding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    UserInfo userInfo=new UserInfo();
    String testStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initData();
    }

    private void initData() {
        userInfo.name="张三";
        userInfo.age="22";
        binding.setUser(userInfo);
        binding.setTestStr("123");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                userInfo.name="张三3";
//                userInfo.age="223";
//                binding.setUser(userInfo);
//                binding.setTestStr("321");
                Log.i("=====","===2=="+userInfo.name);
                Log.i("=====","===2=="+userInfo.age);
            }
        },10000);
    }
    private void initData2() {
        /*userInfo.name="张三";
        userInfo.age="22";

        binding.setUser(userInfo);
        binding.setTestStr("123");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                userInfo.setName("李四");;
                userInfo.setAge("33");
                binding.setTestStr("321");
            }
        },3000);*/
    }
    private void initData3() {
       /* userInfo.name.set("张三3");
        userInfo.age.set("22");

        binding.setUser(userInfo);
        binding.setTestStr("123");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                userInfo.name.set("李四3");
//                userInfo.age.set("33");
//                binding.setTestStr("321");

                Log.i("=====","====="+userInfo.name.get());
                Log.i("=====","====="+userInfo.age.get());
            }
        },10000);*/
    }
}
