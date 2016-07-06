package com.youku.rrtoyewx.newandroid.application;

import android.app.Application;

import com.youku.rrtoyewx.newandroid.net.RetrofitManager;

/**
 * Created by Rrtoyewx on 16/7/6.
 */
public class NewAndroidApplication extends Application {
    private static NewAndroidApplication sApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;
        RetrofitManager.initRetrofitManager();
    }

    public static NewAndroidApplication getApplication() {
        return sApplication;
    }
}
