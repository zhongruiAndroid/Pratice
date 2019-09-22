package com.test.mvvm;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.test.mvvm.databinding.ActivityMainBinding;
import com.test.mvvm.vm.LoginViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initData();
    }

    private void initData() {
        LoginViewModel loginViewModel = new LoginViewModel(binding);
        binding.setVm(loginViewModel);
    }

}
