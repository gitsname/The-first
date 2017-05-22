package com.main.news_information.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.main.news_information.R;

/**
 * 姓名：孙盼盼
 * 时间：2017/5/16
 * 类用途：
 * 思路：
 */

public class News_Activity extends AppCompatActivity {


    private WebView web_view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_act);


        web_view = (WebView) findViewById(R.id.web_view);

        Intent intent = getIntent();

        String s = intent.getStringExtra("url");

        web_view.loadUrl(s);



    }
}
