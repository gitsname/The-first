package com.main.news_information.presenter;

import android.widget.ImageView;

import com.main.news_information.R;
import com.main.news_information.module.one_bean.Headlines_bean;
import com.main.news_information.module.utils.Utils;
import com.main.news_information.view.iview.Item_View;

import org.xutils.image.ImageOptions;
import org.xutils.x;

/**
 * 姓名：孙盼盼
 * 时间：2017/5/11
 * 类用途：
 * 思路：
 */

public class Item_Persenter extends BasePresenter<Item_View> {





    public void getTitleContent(String murl){

        String url="http://result.eolinker.com/k2BaduF2a6caa275f395919a66ab1dfe4b584cc60685573?uri="+murl;
        Utils.getNewsData(url , null, new Utils.GetHttpData() {
            @Override
            public void callback(Object o) {
                getIMVPview().CallHeadlinView((Headlines_bean) o);
            }
        }, Headlines_bean.class);


    }

    public void setImage(ImageView image,String url){
        ImageOptions build = new ImageOptions.Builder()
                .setFailureDrawableId(R.drawable.loading)
                .setLoadingDrawableId(R.drawable.loading)
                .build();

        x.image().bind(image,url,build);

    }









}
