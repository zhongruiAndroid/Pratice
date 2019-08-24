package com.test.pratice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.test.pratice.bean.Book;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/***
 *   created by zhongrui on 2019/8/24
 */
public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    @Subscribe
    public void onEvent(Book book){
        Log.i("========","========BaseActivitybook");
    }
    public void onEve2222nt(Book book){
        Log.i("========","========BaseActivitybook");
    }
}
