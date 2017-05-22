package com.main.news_information.view.fragment.homepagemainfrag;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.limxing.xlistview.view.XListView;
import com.main.news_information.R;
import com.main.news_information.module.one_bean.Headlines_bean;
import com.main.news_information.presenter.Item_Persenter;
import com.main.news_information.view.activity.News_Activity;
import com.main.news_information.view.iview.Item_View;
import com.main.news_information.view.myAdapter.MyBaseAdapter;

import java.util.ArrayList;

/**
 * 姓名：孙盼盼
 * 时间：2017/5/11
 * 类用途：
 * 思路：
 */

public class Item_Fragment extends Fragment implements Item_View{

    private XListView xlv;
    private ArrayList<Headlines_bean.ResultBean.DataBean> arr ;
    private MyBaseAdapter adapter;

    private String murl;

    public Item_Fragment() {

    }

    public Item_Fragment(String murl) {
        this.murl = murl;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.xlistview, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initview();

        initData();


    }

    //加载数据
    private void initData() {




        Item_Persenter item_persenter = new Item_Persenter();

        item_persenter.setIMVPview(this);

        item_persenter.getTitleContent(this.murl);



    }

    //控件
    private void initview() {

        xlv = (XListView) getView().findViewById(R.id.xlv);
        adapter = new MyBaseAdapter(getActivity());
        adapter.setItemFragment(this);

    }


    @Override
    public void CallHeadlinView(final Headlines_bean itembean) {

        arr= (ArrayList<Headlines_bean.ResultBean.DataBean>) itembean.getResult().getData();
        adapter.setList(arr);

        xlv.setAdapter(adapter);


        xlv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getActivity(), News_Activity.class);

                intent.putExtra("url",itembean.getResult().getData().get(position-1).getUrl());
                startActivity(intent);

            }
        });


    }




}
