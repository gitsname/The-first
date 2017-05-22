package com.main.news_information.view.activity;

import android.content.Context;
import android.graphics.Color;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 姓名：孙盼盼
 * 时间：2017/5/14
 * 类用途：
 * 思路：
 */

public class Toast_Show {


    public static void Show(Context context,String  string){

        Toast toast = new Toast(context);

    TextView textView = new TextView(context);
        textView.setText(string);
        textView.setTextColor(Color.parseColor("#FF7171"));
        textView.setTextSize(15);
        toast.setView(textView);
        toast.show();
}

}
