package com.youku.rrtoyewx.newandroid.net.api;

import com.youku.rrtoyewx.newandroid.bean.SplashImageBean;
import com.youku.rrtoyewx.newandroid.net.constants.UrlConstants;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Rrtoyewx on 16/7/6.
 */
public interface SplashImageApi {

    @GET(UrlConstants.SPLASH_LOADING_IMAGE_URL)
    Observable<SplashImageBean> getSplashLoadingImage();
}
