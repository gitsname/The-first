package com.main.news_information.module.utils;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.HashMap;
import java.util.Iterator;

/**
 * 姓名：孙盼盼
 * 时间：2017/5/11
 * 类用途：做网络请求的地方module层。
 * 思路：
 */

public class Utils {

    //方法接收p层传过来的东西，同时自己也在解析数据
    public static <T> void getNewsData(String url, HashMap<String,String> hashMap,
                                       final GetHttpData getHttpData,final Class<T> classutils){

        RequestParams requestParams = new RequestParams(url);

        if (hashMap != null) {

            Iterator<String> iterator = hashMap.keySet().iterator();

            while (iterator.hasNext() ){

                String key = iterator.next();
                String values = hashMap.get(key);

                requestParams.addQueryStringParameter(key,values);

            }



        }

        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                Gson gson = new Gson();
                T t = gson.fromJson(result, classutils);
                getHttpData.callback(t);

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
        
        
        
    }


    //m层的接口，方便往p层传输
    public interface GetHttpData<T>{

        void callback(T t);

    }


}
