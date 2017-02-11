package com.example.service;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

import com.example.service.service.ServiceTest;

/**
 * Created by LL on 2017/2/11.
 */

public class ServiceTestActivity extends Activity {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_activity_test);
        intent = new Intent(this, ServiceTest.class);
        intent.putExtra("ll", "lll");

    }

    public void ondestroy(View view) {
        stopService(intent);

    }

    public void onstart(View view) {
        startService(intent);
    }

    public void onbind(View view) {
        bindService(intent, conn, Context.BIND_AUTO_CREATE);
//        bindService();

    }

    private ServiceTest serviceTest;
    private ServiceConnection conn = new ServiceConnection() {
        /** 获取服务对象时的操作 */
        public void onServiceConnected(ComponentName name, IBinder service) {
            // TODO Auto-generated method stub
            serviceTest = ((ServiceTest.ServiceBinder) service).getService();
            Log.e("TestService", "onServiceConnected");
        }

        /** 无法获取到服务对象时的操作 */
        public void onServiceDisconnected(ComponentName name) {
            // TODO Auto-generated method stub
            serviceTest = null;
            Log.e("TestService", "onServiceDisconnected");
//            Android系统在同service的连接意外丢失时调用这个．比如当service崩溃了或被强杀了．当客户端解除绑定时，这个方法不会被调用．
        }

    };

    public void onunbind(View view) {
//        bindService();
        unbindService(conn);
    }

    @Override
    protected void onDestroy() {
//        stopService(intent);
        super.onDestroy();
//        当你的客户端被销毁，它将从service解除绑定，但是你必须总是在你完成与service的交互时或当你的activity暂停于是service在不被使用时可以关闭此两种情况下解
    }
}
