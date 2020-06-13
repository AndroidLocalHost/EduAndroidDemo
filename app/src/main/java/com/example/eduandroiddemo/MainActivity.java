package com.example.eduandroiddemo;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tttvideo.educationroom.Interface.RoomErrorInterface;
import com.tttvideo.educationroom.JoinEducationActivity;
import com.tttvideo.educationroom.RoomManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, RoomErrorInterface {

    private static String TAG_CLASS = MainActivity.class.getSimpleName();

    private EditText et_room_id;
    private Button bt_enter_room;
    private Context mContext;
    private EditText et_enter_user_id;
    private String userID;
    private EditText et_enter_expiresIn;
    private EditText et_enter_safekey;
    private EditText et_enter_time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;
        initView();
        findViewId();
        boolean permissionInit = permissionInit();


    }

    private void initView() {
        Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);
        RoomManager.getInstance().setLoadIngIcon(drawable);
        RoomManager.getInstance().setRoomErrorInterface(this);
    }

    private void findViewId() {
        et_room_id = findViewById(R.id.et_enter_room_id);
        bt_enter_room = findViewById(R.id.bt_enter_room);
        et_enter_user_id = findViewById(R.id.et_enter_user_id);
        et_enter_expiresIn = findViewById(R.id.et_enter_expiresIn);
        et_enter_safekey = findViewById(R.id.et_enter_safekey);
        et_enter_time = findViewById(R.id.et_enter_time);
        bt_enter_room.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_enter_room:
                String roomid = et_room_id.getText().toString().trim();
                userID = et_enter_user_id.getText().toString().trim();
                String expiresIn = et_enter_expiresIn.getText().toString().trim();
                String safeKey = et_enter_safekey.getText().toString().trim();
                String time = et_enter_time.getText().toString().trim();

                if (TextUtils.isEmpty(roomid)) {
                    Toast.makeText(mContext, "会议ID不能为空", Toast.LENGTH_SHORT).show();
                    return;
                } else if (TextUtils.isEmpty(userID)) {
                    Toast.makeText(mContext, " 用户ID不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(expiresIn) && TextUtils.isEmpty(safeKey) && TextUtils.isEmpty(time)) {
                    Toast.makeText(mContext, " 数据不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = JoinEducationActivity.createIntent(this,
                        userID,
                        safeKey,
                        time,
                        Integer.parseInt(expiresIn),
                        roomid);
                startActivity(intent);


                break;
            default:
                break;
        }

    }

    //获取权限
    public boolean permissionInit() {
        final ArrayList<PermissionBean> mPermissionList = new ArrayList<>();
        mPermissionList.add(new PermissionBean(Manifest.permission.WRITE_EXTERNAL_STORAGE, "程序需要缓存一些数据在SD卡，否则无法运行."));
        mPermissionList.add(new PermissionBean(Manifest.permission.CAMERA, "程序需要使用摄像头权限用来音视频通话，否则无法运行."));
        mPermissionList.add(new PermissionBean(Manifest.permission.RECORD_AUDIO, "程序需要录音权限用来音视频通话，否则无法运行."));
        mPermissionList.add(new PermissionBean(Manifest.permission.READ_PHONE_STATE, "程序需要电话监听权限用来音视频通话，否则无法运行."));

        boolean isOk = PermissionUtils.checkPermission(mContext, new PermissionUtils.PermissionUtilsInter() {
            @Override
            public List<PermissionBean> getApplyPermissions() {
                return mPermissionList;
            }

            @Override
            public AlertDialog.Builder getTipAlertDialog() {
                return null;
            }

            @Override
            public Dialog getTipDialog() {
                return null;
            }

            @Override
            public AlertDialog.Builder getTipAppSettingAlertDialog() {
                return null;
            }

            @Override
            public Dialog getTipAppSettingDialog() {
                return null;
            }
        });

        return isOk;

    }

    @Override
    public void onRoomError(int i) {

    }

    @Override
    public void onRoomExit(String s) {

    }

    @Override
    public void onRoomSuccess(String s) {

    }

    @Override
    public PopupWindow showShareWindow(Activity activity, String s, String s1, String s2, String s3, String s4, String s5) {
        return null;
    }


}