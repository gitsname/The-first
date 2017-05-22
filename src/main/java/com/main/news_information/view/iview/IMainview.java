package com.main.news_information.view.iview;

import android.support.v4.app.Fragment;

import java.util.ArrayList;

/**
 * 姓名：孙盼盼
 * 时间：2017/5/9
 * 类用途：接口回调1.建立接口2.建立抽象方法
 * 思路：
 */

public interface IMainview extends IMVPview {

    void Callbackfragments(ArrayList<Fragment> fragments);

}
