package com.youku.rrtoyewx.newandroid.manager;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Rrtoyewx on 16/7/6.
 */
public class SharePreferenceManager {
    private static String NEW_ANDROID_SHARED_PREFERENCE_FILE = "new_android_shared_preference_file";
    private static String LOCAL_SPLASH_IMAGE_TEXT = "local_splash_image_text";
    private static String LOCAL_SPLASH_IMAGE_URL = "local_splash_image_url";

    private static SharePreferenceManager sPreferencesManager;
    private final SharedPreferences mCommonSharedPreferences;

    private SharePreferenceManager(Context context) {
        mCommonSharedPreferences = context.getSharedPreferences(NEW_ANDROID_SHARED_PREFERENCE_FILE, Context.MODE_PRIVATE);
    }

    public static SharePreferenceManager getsPreferencesManager(Context context) {
        if (sPreferencesManager == null) {
            sPreferencesManager = new SharePreferenceManager(context);
        }
        return sPreferencesManager;
    }

    public void setLocalSplashImageText(String title) {
        mCommonSharedPreferences.edit().putString(LOCAL_SPLASH_IMAGE_TEXT, title).apply();
    }

    public String getLocalSplashImageText() {
        return mCommonSharedPreferences.getString(LOCAL_SPLASH_IMAGE_TEXT, "");
    }

    public void setLocalSplashImageUrl(String url) {
        mCommonSharedPreferences.edit().putString(LOCAL_SPLASH_IMAGE_URL, url).apply();
    }

    public String getLocalSplashImageUrl() {
        return mCommonSharedPreferences.getString(LOCAL_SPLASH_IMAGE_URL, "");
    }

    public void clear(){
        mCommonSharedPreferences.edit().clear().apply();
    }
}
