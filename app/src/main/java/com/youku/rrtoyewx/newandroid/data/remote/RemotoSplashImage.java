package com.youku.rrtoyewx.newandroid.data.remote;

import com.youku.rrtoyewx.newandroid.application.NewAndroidApplication;
import com.youku.rrtoyewx.newandroid.bean.SplashImageBean;
import com.youku.rrtoyewx.newandroid.data.SplashImage;
import com.youku.rrtoyewx.newandroid.manager.SharePreferenceManager;
import com.youku.rrtoyewx.newandroid.net.RetrofitManager;
import com.youku.rrtoyewx.newandroid.net.api.SplashImageApi;

import rx.Observable;

/**
 * Created by Rrtoyewx on 16/7/6.
 * 远程的仓库
 */
public class RemotoSplashImage implements SplashImage {

    private SplashImageApi getSerive() {
        return RetrofitManager.getRetrofitInstance().create(SplashImageApi.class);
    }

    @Override
    public Observable<SplashImageBean> getSplashImageBean() {
        return getSerive().getSplashLoadingImage();
    }

    @Override
    public Observable<Boolean> saveSplashImageBean(SplashImageBean bean) {
        SharePreferenceManager.getsPreferencesManager(NewAndroidApplication.getApplication()).setLocalSplashImageText(bean.getText());
        SharePreferenceManager.getsPreferencesManager(NewAndroidApplication.getApplication()).setLocalSplashImageUrl(bean.getImg());

        return Observable.just(new Boolean(false));
    }

    @Override
    public Observable<Boolean> deleteSplashImageBean(SplashImageBean bean) {
        return Observable.just(new Boolean(false));
    }

    @Override
    public Observable<SplashImageBean> updateSplashImageBean(SplashImageBean bean) {
        SharePreferenceManager.getsPreferencesManager(NewAndroidApplication.getApplication()).setLocalSplashImageText(bean.getText());
        SharePreferenceManager.getsPreferencesManager(NewAndroidApplication.getApplication()).setLocalSplashImageUrl(bean.getImg());

        return Observable.just(bean);
    }

}
