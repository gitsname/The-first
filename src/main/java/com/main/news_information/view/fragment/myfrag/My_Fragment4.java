package com.main.news_information.view.fragment.myfrag;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.main.news_information.R;
import com.main.news_information.view.activity.LoginActivity;
import com.main.news_information.view.activity.Toast_Show;

/**
 * 姓名：孙盼盼
 * 时间：2017/5/10
 * 类用途：
 * 思路：
 */

public class My_Fragment4 extends Fragment implements View.OnClickListener{


    private TextView choose;
    private ImageButton weibo;
    private ImageButton phone;

    private ImageButton qq;
    private RadioButton history;
    private RadioButton collection;
    private RadioButton type;
    private TextView text1_f4;
    private TextView text2_f4;
    private TextView text3_f4;
    private TextView text4_f4;
    private TextView text5_f4;
    private TextView text6_f4;

    //设置标记,是否是夜间模式
    private boolean isNightmode = false;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_frag4, null, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //各个控件
        initView(view);
    }

    private void initView(View view) {

        choose = (TextView) view.findViewById(R.id.choose);
        weibo = (ImageButton) view.findViewById(R.id.weibo);
        qq = (ImageButton) view.findViewById(R.id.qq);
        phone = (ImageButton) view.findViewById(R.id.phone);

        collection = (RadioButton) view.findViewById(R.id.collection);
        history = (RadioButton) view.findViewById(R.id.history);
        type = (RadioButton) view.findViewById(R.id.type);


        text1_f4 = (TextView) view.findViewById(R.id.text1_f4);
        text2_f4 = (TextView) view.findViewById(R.id.text2_f4);
        text3_f4 = (TextView) view.findViewById(R.id.text3_f4);
        text4_f4 = (TextView) view.findViewById(R.id.text4_f4);
        text5_f4 = (TextView) view.findViewById(R.id.text5_f4);
        text6_f4 = (TextView) view.findViewById(R.id.text6_f4);

        collection.setOnClickListener(this);
        history.setOnClickListener(this);
        type.setOnClickListener(this);
        text1_f4.setOnClickListener(this);
        text2_f4.setOnClickListener(this);
        text3_f4.setOnClickListener(this);
        text4_f4.setOnClickListener(this);
        text5_f4.setOnClickListener(this);
        text6_f4.setOnClickListener(this);

        qq.setOnClickListener(this);
        phone.setOnClickListener(this);
        weibo.setOnClickListener(this);





        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("nightAndDay", getActivity().MODE_PRIVATE);

        boolean isNightmode = sharedPreferences.getBoolean("isNightmode", false);

        if (isNightmode){
        type.setText("日间");
        }else{
            type.setText("夜间");
        }


    }

    @Override
    public void onClick(View v) {


        switch (v.getId()){

            //点击qq图片跳转到登陆界面
            case R.id.qq:

                Intent intent = new Intent(getActivity(), LoginActivity.class);

                getActivity().startActivity(intent);

                break;
            //收藏button
            case R.id.collection:
               // Toast.makeText(getActivity(), "这是收藏", Toast.LENGTH_SHORT).show();
                Toast_Show.Show(getActivity(),"这是收藏");
                break;
            //历史button
            case R.id.history:
                Toast.makeText(getActivity(), "你的历史足迹", Toast.LENGTH_SHORT).show();
                break;


            //日夜间模式切换的监听
            case R.id.type:

                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("nightAndDay", getActivity().MODE_PRIVATE);

                SharedPreferences.Editor edit = sharedPreferences.edit();

                boolean isnight1 = sharedPreferences.getBoolean("isNightmode", false);

                if (!isnight1){

                    getActivity().setTheme(R.style.NightTheme);
                    edit.putBoolean("isNightmode",true);
                    edit.putInt("position",3);
                    edit.commit();
//                    Toast.makeText(getActivity(), "1", Toast.LENGTH_SHORT).show();

                }else{
                    getActivity().setTheme(R.style.DayTheme);
                    edit.putBoolean("isNightmode",false);
                    edit.putInt("position",3);
                    edit.commit();
//                    Toast.makeText(getActivity(), "2", Toast.LENGTH_SHORT).show();
                }

                getActivity().recreate();

                break;
            //text1_f4的textview
            case R.id.text1_f4:
                Toast.makeText(getActivity(), "text1_f4", Toast.LENGTH_SHORT).show();
                break;
            //text2_f4的textview
            case R.id.text2_f4:
                Toast.makeText(getActivity(), "text2_f4", Toast.LENGTH_SHORT).show();
                break;
            //text3_f4的textview
            case R.id.text3_f4:
                Toast.makeText(getActivity(), "text3_f4", Toast.LENGTH_SHORT).show();
                break;
            //text4_f4的textview
            case R.id.text4_f4:
                Toast.makeText(getActivity(), "text4_f4", Toast.LENGTH_SHORT).show();
                break;
            //text5_f4的textview
            case R.id.text5_f4:
                Toast.makeText(getActivity(), "text5_f4", Toast.LENGTH_SHORT).show();
                break;
            //text6_f4的textview
            case R.id.text6_f4:
                Toast.makeText(getActivity(), "text6_f4", Toast.LENGTH_SHORT).show();
                break;



        }





    }
}
