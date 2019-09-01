package com.test.pratice;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.test.pratice.bean.Book;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        MyBus.get().register(this);

//        MyBus.get().post(new Book());



//        EventBus.getDefault().post(new Book());
        EventBus.getDefault().postSticky(new Book());
        startActivity(new Intent(this,Main2Activity.class));

        EventBus.getDefault().register(this);
    }
   /* @com.test.pratice.eventbus.Subscribe(threadMode= com.test.pratice.eventbus.ThreadMode.MAIN)
    public void onEven1t(Book book){
        Log.i("========","=======book"+Thread.currentThread().getName());
    }*/
    @Subscribe(threadMode= ThreadMode.MAIN,sticky = true,priority = 11)
    public void onEven21t(Book book){
        Log.i("========","======11=book"+Thread.currentThread().getName());
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


}
