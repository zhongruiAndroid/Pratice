package com.test.pratice;

import android.os.Bundle;
import android.util.Log;

import com.test.pratice.bean.Book;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EventBus.getDefault().register(this);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().post(new Book());
    }
    @Subscribe
    public void onEven1t(Book book){
        Log.i("========","=======book");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        EventBus.getDefault().unregister(this);
    }


}
