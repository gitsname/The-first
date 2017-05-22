package com.main.news_information.view.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.main.news_information.R;
import com.main.news_information.presenter.IMainPersenter;
import com.main.news_information.view.iview.IMainview;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements IMainview, View.OnClickListener {


    private String tt;
    private int ee;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private RadioGroup rg;
    private LinearLayout lin_lay;
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private int index = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //日夜间切换
        SharedPreferences sharedPreferences = getSharedPreferences("nightAndDay", Context.MODE_PRIVATE);
        boolean isnight1 = sharedPreferences.getBoolean("isNightmode", false);

        //判断状态来切换状态。
        if (isnight1) {
            setTheme(R.style.NightTheme);
        } else {
            setTheme(R.style.DayTheme);
        }

        //初始化控件
        setContentView(R.layout.activity_main);

        //控件的id
        initview();


        initdata();



        int position = sharedPreferences.getInt("position", 0);

        showFragment(fragments,position);

        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt("position", 0);
        edit.commit();

    }


    private void initdata() {

        IMainPersenter IMainPersenter = new IMainPersenter();
        IMainPersenter.setIMVPview(this);
        IMainPersenter.getFragments();


    }

    //四个主控件 的id
    private void initview() {

        lin_lay = (LinearLayout) findViewById(R.id.lin_lay);
        rg = (RadioGroup) findViewById(R.id.rg);
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
        rb3 = (RadioButton) findViewById(R.id.rb3);
        rb4 = (RadioButton) findViewById(R.id.rb4);

        rb1.setOnClickListener(this);
        rb2.setOnClickListener(this);
        rb3.setOnClickListener(this);
        rb4.setOnClickListener(this);

    }

    /**
     * 实现接口重写的方法
     *
     * @param
     */
    @Override
    public void Callbackfragments(ArrayList<Fragment> fragments) {

        if (fragments != null) {
            this.fragments.clear();
            this.fragments.addAll(fragments);
        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        for (int i = 0; i < fragments.size(); i++) {

            transaction.add(R.id.lin_lay, fragments.get(i));

        }
        transaction.commit();

    }


    /**
     * 监听重写的方法
     *
     * @param v
     */
    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.rb1:

                index = 0;

                break;
            case R.id.rb2:

                index = 1;

                break;
            case R.id.rb3:

                index = 2;

                break;
            case R.id.rb4:

                index = 3;

                break;

        }

     showFragment(fragments,index);


    }



    private void showFragment(ArrayList<Fragment> fragments,int position){


        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        for (int i = 0; i < fragments.size(); i++) {
            transaction.hide(fragments.get(i));
        }
        transaction.show(fragments.get(position));
        transaction.commit();

    }


    @Override
    public void recreate() {
        try {//避免重启太快 恢复
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            for (Fragment fragment : fragments) {
                fragmentTransaction.remove(fragment);
            }
            fragmentTransaction.commitAllowingStateLoss();
        } catch (Exception e) {
        }
        super.recreate();

    }
}
