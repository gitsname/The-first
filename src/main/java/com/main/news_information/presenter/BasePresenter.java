package com.main.news_information.presenter;

import com.main.news_information.view.iview.IMVPview;

/**
 * 姓名：孙盼盼
 * 时间：2017/5/11
 * 类用途：
 * 思路：
 */

public class BasePresenter<T extends IMVPview> {

    private T t;

    public void setIMVPview(T t){
        this.t = t;
    }

    public T getIMVPview() {
        return t;
    }

}
