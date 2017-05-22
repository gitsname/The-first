package com.main.news_information.view.myapplication;

import android.app.Application;
import android.support.v7.appcompat.BuildConfig;

import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import org.xutils.x;

/**
 * 姓名：孙盼盼
 * 时间：2017/5/11
 * 类用途：
 * 思路：
 */

public class Myapplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //初始化
        UMShareAPI.get(this);
        //设置qq平台的id和key
        PlatformConfig.setQQZone("1106086069","BbUDh6t7rYjJWowh");

        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);

    }
}
