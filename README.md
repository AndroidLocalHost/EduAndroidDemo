# EduAndroidDemo
Android AAR 项目集成

前言

    minSdkVersion 19
    targetSdkVersion 29


一 . 引入AA包

   将libs下aar包放在对应的工程目录下,并添加引用

    implementation files('libs/AAR1包名.aar')
    implementation files('libs/AAR2包名.aar')

二 . 依赖第三方引用

     因AAR包携带UI界面,需引用一下第三方库, 具体引用请查看build.gradle , 相同的引用可以不添加, 不同的全部添加

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

五 . 设置进入直播间界面显示图标

    //参数类型Drawable
    //在跳转直播进度页之前设置 , 大小为 wrap_content , xhdp推荐尺寸362*108
    RoomManager.getInstance().setLoadIngIcon(drawable);

六 . 接口回调

    1 .实现方式
        implements RoomErrorInterface
    2 .接收回调
        RoomManager.getInstance().setRoomErrorInterface(RoomErrorInterface);
    3 .回调方法
        //直播间错误信息
        void onRoomError(int error);
        //退出房间
        void onRoomExit(String userId);
        //进入房间成功
        void onRoomSuccess(String userId);
        //分享
        PopupWindow showShareWindow(Activity activity, String shareUrl, String iconUrl,
                                    String title, String description, String copyUrl, String roomId);






























