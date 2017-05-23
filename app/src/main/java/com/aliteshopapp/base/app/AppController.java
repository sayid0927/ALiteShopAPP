package com.aliteshopapp.base.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.aliteshopapp.base.PreferUtil;
import com.aliteshopapp.base.service.BaseService;
import com.blankj.utilcode.utils.Utils;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
 * Created by susion on 17/1/17.
 */
public class AppController extends Application {

    private static Context sContext;
    private static AppController instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Utils.init(this);
        PreferUtil.getInstance().init(this);
        Intent intent = new Intent(this, BaseService.class);
        startService(intent);
        initLogger();
    }

    private void initLogger() {
        Logger.init("aliteshopapp").methodCount(2).methodOffset(0).logLevel(LogLevel.FULL).hideThreadInfo();
    }
}
