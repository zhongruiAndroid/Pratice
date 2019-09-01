package com.test.pratice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.test.pratice.bean.Book;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EventBus.getDefault().register(this);
        setContentView(R.layout.activity_main2);
    }
    @Subscribe(threadMode= ThreadMode.MAIN,sticky = true,priority = 12)
    public void onEven211t(Book book){
        Log.i("========","======12=book"+Thread.currentThread().getName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        EventBus.getDefault().unregister(new Book());
    }
}
