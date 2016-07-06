package com.youku.rrtoyewx.newandroid.data;

import android.text.TextUtils;

import com.youku.rrtoyewx.newandroid.application.NewAndroidApplication;
import com.youku.rrtoyewx.newandroid.bean.SplashImageBean;
import com.youku.rrtoyewx.newandroid.data.local.LocalSplashImage;
import com.youku.rrtoyewx.newandroid.data.remote.RemotoSplashImage;
import com.youku.rrtoyewx.newandroid.manager.SharePreferenceManager;

import rx.Observable;

/**
 * Created by Rrtoyewx on 16/7/6.
 */
public interface SplashImage {
    int DISPLAY_ONLY_SHOW_NET = 0;
    int DISPLAY_SHOW_LOCAL_IF_HAVE = 1;

    Observable<SplashImageBean> getSplashImageBean();

    Observable<Boolean> saveSplashImageBean(SplashImageBean bean);

    Observable<Boolean> deleteSplashImageBean(SplashImageBean bean);

    Observable<SplashImageBean> updateSplashImageBean(SplashImageBean bean);

    class SplashImageFactory {
        public SplashImageFactory() {
        }

        public SplashImage newInstance(int priority) {
            switch (priority) {
                case DISPLAY_SHOW_LOCAL_IF_HAVE:
                    if(!TextUtils.isEmpty(SharePreferenceManager.getsPreferencesManager(NewAndroidApplication.getApplication()).getLocalSplashImageUrl())){
                        return new LocalSplashImage();
                    }

                default:
                case DISPLAY_ONLY_SHOW_NET:
                    return new RemotoSplashImage();
            }
        }
    }

}
