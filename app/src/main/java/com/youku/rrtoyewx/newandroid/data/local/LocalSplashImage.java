package com.youku.rrtoyewx.newandroid.data.local;

import com.youku.rrtoyewx.newandroid.application.NewAndroidApplication;
import com.youku.rrtoyewx.newandroid.bean.SplashImageBean;
import com.youku.rrtoyewx.newandroid.data.SplashImage;
import com.youku.rrtoyewx.newandroid.manager.SharePreferenceManager;

import rx.Observable;

/**
 * Created by Rrtoyewx on 16/7/6.
 */
public class LocalSplashImage implements SplashImage {

    @Override
    public Observable<SplashImageBean> getSplashImageBean() {
        String text = SharePreferenceManager.getsPreferencesManager(NewAndroidApplication.getApplication()).getLocalSplashImageText();
        String image = SharePreferenceManager.getsPreferencesManager(NewAndroidApplication.getApplication()).getLocalSplashImageUrl();

        return Observable.just(new SplashImageBean(text, image));
    }

    @Override
    public Observable<Boolean> saveSplashImageBean(SplashImageBean bean) {
        return Observable.just(new Boolean(true));
    }

    @Override
    public Observable<Boolean> deleteSplashImageBean(SplashImageBean bean) {
        SharePreferenceManager.getsPreferencesManager(NewAndroidApplication.getApplication()).clear();
        return Observable.just(new Boolean(true));
    }

    @Override
    public Observable<SplashImageBean> updateSplashImageBean(SplashImageBean bean) {
        return Observable.just(bean);
    }
}
