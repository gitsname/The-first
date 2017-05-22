package com.main.news_information.presenter;

import com.main.news_information.module.utils.Utils;
import com.main.news_information.view.iview.IHomePageView;

import java.util.HashMap;

/**
 * 姓名：孙盼盼
 * 时间：2017/5/11
 * 类用途：P层
 * 思路：
 */

public class HomePagePersenter extends BasePresenter<IHomePageView>{

    //首页标题的网址
    private String url="http://result.eolinker.com/gfGTLlHc049c6b450500b16971f52bd8e83f6b2fed305ab?" +
            "uri=news";

    //key和values值的形式
    private HashMap<String,String> hashMap = new HashMap<>();

    //自己的方法
    public  <T> void getTitleData(final Class<T> tClass){

        Utils.getNewsData(url, hashMap, new Utils.GetHttpData<T>() {
            @Override
            public void callback(Object o) {

                //BasePresenter里面的方法，调用IHomePageView里面的方法。
                getIMVPview().getBack(o);

            }
        },tClass);

    }


}
