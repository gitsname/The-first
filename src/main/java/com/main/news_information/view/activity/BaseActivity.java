package com.main.news_information.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * 姓名：孙盼盼
 * 时间：2017/5/13
 * 类用途：
 * 思路：
 */

public class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         getSupportActionBar().hide();

    }
}
