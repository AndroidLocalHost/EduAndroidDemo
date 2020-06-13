# EduAndroidDemo
Android AAR 项目集成

一 . 引入AA包

   将libs下aar包放在对应的工程目录下,并添加引用

    implementation files('libs/3T_Native_SDK_for_Android_V2.9.6_Full_2020_05_17.aar')
    implementation files('libs/3T_edu_Android_aar_200612.aar')

二 . 依赖第三方引用

     因AAR包携带UI界面,需引用一下第三方库, 具体引用请查看build.gradle

三 . 初始化

    在本地 Application 中初始化参数
    	1 . 设置接口域名 , 三体接口域名 : https://api3tclass.3ttech.cn
    		RoomManager.getInstance().setBaseUrl("请求接口链接");
    	2 . 初始化日志打印工具
            LogAarUtil.initLogUtil(getApplicationContext());
    	3 . 初始化白板功能
            InitWebView.getInstance().initView(getApplicationContext());