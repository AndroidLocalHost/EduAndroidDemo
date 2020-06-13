package com.example.eduandroiddemo;

import android.app.Application;

import com.tttvideo.educationroom.RoomManager;
import com.tttvideo.educationroom.util.InitWebView;
import com.tttvideo.educationroom.util.LogAarUtil;

/**
 * Created by Administrator on 2020/06/13 0013.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        RoomManager.getInstance().setBaseUrl("https://api3tclass.3ttech.cn");
        LogAarUtil.initLogUtil(getApplicationContext());
        InitWebView.getInstance().initView(getApplicationContext());


    }
}
