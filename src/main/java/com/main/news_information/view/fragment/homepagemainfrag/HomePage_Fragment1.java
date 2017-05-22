package com.main.news_information.view.fragment.homepagemainfrag;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.main.news_information.R;
import com.main.news_information.module.one_bean.Title_Bean;
import com.main.news_information.presenter.HomePagePersenter;
import com.main.news_information.view.iview.IHomePageView;
import com.main.news_information.view.myAdapter.MyFragvAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 姓名：孙盼盼
 * 时间：2017/5/9
 * 类用途：
 * 思路：
 */

public class HomePage_Fragment1 extends Fragment implements IHomePageView<Title_Bean>{

    private TabLayout tab;
    private ViewPager view_pager;
    private ArrayList<Fragment>   fragments = new ArrayList<>();
    private MyFragvAdapter adapter;
    private int index;
    private List<Title_Bean.ResultBean.DateBean> date;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_frag1,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initview();

        initData();



    }

    private void initview() {

        tab = (TabLayout) getActivity().findViewById(R.id.tab);

        //tab.setTabTextColors(R.attr.MyColor,R.attr.MyColor);

        view_pager = (ViewPager) getActivity().findViewById(R.id.view_pager);


    }

    private void initData() {


        HomePagePersenter homePagePersenter = new HomePagePersenter();
        homePagePersenter.setIMVPview(this);
        homePagePersenter.getTitleData(Title_Bean.class);


    }

    @Override
    public void getBack(Title_Bean title_bean) {

        date = title_bean.getResult().getDate();

        for (int i = 0; i < date.size() ; i++) {

            tab.addTab(tab.newTab().setText( date.get(i).getTitle()));

            this.fragments.add(new Item_Fragment(date.get(i).getUri()));

        }

        mySetAdapter();



    }

    private void mySetAdapter() {


        adapter = new MyFragvAdapter(getActivity().getSupportFragmentManager(),
                getActivity(), this.fragments,date);
        // tab.setTabsFromPagerAdapter(adapter);
        view_pager.setAdapter(adapter);

        tab.setupWithViewPager(view_pager,false);

    }


}
