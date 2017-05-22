package com.main.news_information.view.activity;

import android.app.Application;

import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

/**
 * 姓名：孙盼盼
 * 时间：2017/5/12
 * 类用途：
 * 思路：
 */

public class App extends Application {

    {
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
    }
    @Override
    public void onCreate() {
        super.onCreate();

        UMShareAPI.get(this);


    }

}
