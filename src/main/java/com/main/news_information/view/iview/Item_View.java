package com.main.news_information.view.iview;

import com.main.news_information.module.one_bean.Headlines_bean;

/**
 * 姓名：孙盼盼
 * 时间：2017/5/11
 * 类用途：
 * 思路：
 */

public interface Item_View<T> extends IMVPview{

    void CallHeadlinView(Headlines_bean itembean);

}
