package com.example.service.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by LL on 2017/2/11.
 */

public class ServiceTest extends Service {

    @Override
    public void onCreate() {
        l("oncreate");
        super.onCreate();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        l("onstart:" + intent.getStringExtra("ll"));
        super.onStart(intent, startId);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        l("onstartcommand:" + intent.getStringExtra("ll"));
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        l("onbind:" + intent.getStringExtra("ll"));
        return new ServiceBinder();
    }

    @Override
    public void onRebind(Intent intent) {
        l("onrebind:" + intent.getStringExtra("ll"));
        super.onRebind(intent);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        l("onunbind:" + intent.getStringExtra("ll"));
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        l("ondestroy");
        super.onDestroy();
    }

    private String tag = "TestService";

    private void l(String msg) {
        Log.e(tag, msg);
    }

    private String p = "aa";

    //此方法是为了可以在Acitity中获得服务的实例
    public class ServiceBinder extends Binder {
        public ServiceTest getService() {
            String pp = p;
            return ServiceTest.this;
        }
    }
}
