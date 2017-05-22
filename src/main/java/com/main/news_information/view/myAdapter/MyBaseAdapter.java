package com.main.news_information.view.myAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.main.news_information.R;
import com.main.news_information.module.one_bean.Headlines_bean;
import com.main.news_information.presenter.Item_Persenter;
import com.main.news_information.view.fragment.homepagemainfrag.Item_Fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 姓名：孙盼盼
 * 时间：2017/5/11
 * 类用途：
 * 思路：
 */

public class MyBaseAdapter extends BaseAdapter {

    private Context context;
    private List<Headlines_bean.ResultBean.DataBean> list=new ArrayList<>();
    private int type;

    private final int type1 = 0;
    private final int type2 = 1;
    private final int type3 = 2;
    private Item_Fragment item_fragment;

    private Item_Persenter item_presenter = new Item_Persenter();


    public MyBaseAdapter(Context context) {
        this.context = context;
    }


    public void setItemFragment(Item_Fragment item_fragment) {

        this.item_fragment = item_fragment;


    }

    public void setList(ArrayList<Headlines_bean.ResultBean.DataBean> arr) {

        if (arr!=null){

            this.list.addAll(arr);
        }


    }

    //可以多条目加载
    public void addMore(List<Headlines_bean.ResultBean.DataBean> list,boolean isRefresh){

        for (Headlines_bean.ResultBean.DataBean data : list){

            if (isRefresh){

                list.add(0,data);

            }else {
                list.add(data);
            }

        }


    }


    @Override
    public int getCount() {
        return list != null ? list.size() : 0 ;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {

        String pic1 = list.get(position).getThumbnail_pic_s();
        String pic2 = list.get(position).getThumbnail_pic_s02();
        String pic3 = list.get(position).getThumbnail_pic_s03();

        if (pic1 != null && pic2 != null && pic3 != null ){

            return type3;

        }else if (pic1 != null && pic2 != null ){

            return type2;
        }else {
            return type1;
        }


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        int itemViewType = getItemViewType(position);


        switch (itemViewType){

            //上面是text下面是image
            case type1: {
                if (convertView == null) {
                    convertView = View.inflate(context, R.layout.item1_f1, null);
                }

                TextView text_item1f1 = (TextView) convertView.findViewById(R.id.text_t1);
                ImageView image_item2f1 = (ImageView) convertView.findViewById(R.id.image_t1);

                item_presenter.setImage(image_item2f1,list.get(position).getThumbnail_pic_s());

                text_item1f1.setText(list.get(position).getTitle());

                return convertView;

            }

            //左面是text右面是image
            case type2: {
                if (convertView == null) {
                    convertView = View.inflate(context, R.layout.item2_f1, null);
                }

                ImageView image1_item2f1 = (ImageView) convertView.findViewById(R.id.image1_t2);
                ImageView image2_item2f1 = (ImageView) convertView.findViewById(R.id.image2_t2);
                TextView text_item2f1 = (TextView) convertView.findViewById(R.id.text_t2);

                text_item2f1.setText(list.get(position).getTitle());

                item_presenter.setImage(image1_item2f1,list.get(position).getThumbnail_pic_s());
                item_presenter.setImage(image2_item2f1,list.get(position).getThumbnail_pic_s02());

                return convertView;
            }
            case type3: {
                if (convertView == null) {
                    convertView = View.inflate(context, R.layout.item3_f1, null);
                }

                TextView text_item2f1 = (TextView) convertView.findViewById(R.id.text_t3);
                ImageView image1_item3f1 = (ImageView) convertView.findViewById(R.id.image1_t3);
                ImageView image2_item3f1 = (ImageView) convertView.findViewById(R.id.image2_t3);
                ImageView image3_item3f1 = (ImageView) convertView.findViewById(R.id.image3_t3);

                text_item2f1.setText(list.get(position).getTitle());
                item_presenter.setImage(image1_item3f1,list.get(position).getThumbnail_pic_s());
                item_presenter.setImage(image2_item3f1,list.get(position).getThumbnail_pic_s02());
                item_presenter.setImage(image3_item3f1,list.get(position).getThumbnail_pic_s03());

                return convertView;
            }

        }



        return null;
    }



}
