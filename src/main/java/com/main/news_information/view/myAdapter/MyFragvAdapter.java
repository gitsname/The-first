package com.main.news_information.view.myAdapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.main.news_information.module.one_bean.Title_Bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 姓名：孙盼盼
 * 时间：2017/5/11
 * 类用途：
 * 思路：
 */

public class MyFragvAdapter extends FragmentPagerAdapter {

    private final List<Title_Bean.ResultBean.DateBean> title_list=new ArrayList<>();
    private Context context;
    private List<Fragment> fragments=new ArrayList<>();

    public MyFragvAdapter(FragmentManager fm, Context context, List<Fragment> fragments,
                          List<Title_Bean.ResultBean.DateBean> title_list) {
        super(fm);
        this.context = context;
        if (fragments!=null){
            this.fragments.clear();
            this.fragments.addAll(fragments);
        }
        if (title_list!=null){
            this.title_list.clear();
            this.title_list.addAll(title_list);
        }

    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }



    @Override
    public CharSequence getPageTitle(int position) {

        return title_list.get(position).getTitle();

    }
}
