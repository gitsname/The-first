package com.main.news_information.presenter;

import android.support.v4.app.Fragment;

import com.main.news_information.view.fragment.homepagemainfrag.HomePage_Fragment1;
import com.main.news_information.view.fragment.myfrag.My_Fragment4;
import com.main.news_information.view.fragment.threefrag.Fragment3;
import com.main.news_information.view.fragment.videofrag.VideoFragment2;
import com.main.news_information.view.iview.IMainview;

import java.util.ArrayList;

/**
 * 姓名：孙盼盼
 * 时间：2017/5/9
 * 类用途：产生数据的地方   逻辑操作
 * 思路：
 */

public class IMainPersenter extends BasePresenter<IMainview> {

    private ArrayList<Fragment> fragments;
    private HomePage_Fragment1 fragment1;
    private VideoFragment2 fragment2;
    private Fragment3 fragment3;
    private My_Fragment4 fragment4;


    public void getFragments(){
        fragment1 = new HomePage_Fragment1();
        fragment2 = new VideoFragment2();
        fragment3 = new Fragment3();
        fragment4 = new My_Fragment4();

        fragments = new ArrayList<>();

        fragments.add(fragment1);
        fragments.add(fragment2);
        fragments.add(fragment3);
        fragments.add(fragment4);

        getIMVPview().Callbackfragments(fragments);
    }

















}
