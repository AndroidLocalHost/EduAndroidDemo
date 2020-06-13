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
    	1 . 设置接口域名
    	    RoomManager.getInstance().setBaseUrl("请求接口链接");
    	2 . 初始化日志打印工具
    	    LogAarUtil.initLogUtil(getApplicationContext());
    	3 . 初始化白板功能
    	    InitWebView.getInstance().initView(getApplicationContext());

四 . 进入课堂直播间参数说明
    Intent intent = JoinEducationActivity.createIntent(this,
    	           userId,
    	           safeKey,
    	           timeStamp,
    	           expiresIn,
    	           classId);
    	   startActivity(intent);

    	userId :  用户id
    	safeKey : 用户safeKey
    	timeStamp : 用户时间戳
    	expiresIn : safekey 有效期
    	classId : 课节id

    以上这些参数需要通过后台请求获取









