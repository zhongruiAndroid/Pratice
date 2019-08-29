package com.test.pratice;

import android.os.Bundle;
import android.util.Log;

import com.test.pratice.bean.Book;
import com.test.pratice.eventbus.MyBus;

import org.greenrobot.eventbus.EventBus;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyBus.get().register(this);

        MyBus.get().post(new Book());



        EventBus.getDefault().register(this);
        EventBus.getDefault().post(new Book());
        EventBus.getDefault().postSticky(new Book());
    }
    @com.test.pratice.eventbus.Subscribe(threadMode= com.test.pratice.eventbus.ThreadMode.MAIN)
    public void onEven1t(Book book){
        Log.i("========","=======book"+Thread.currentThread().getName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        EventBus.getDefault().unregister(this);
    }


}
