package com.youku.rrtoyewx.newandroid.splash;

import com.youku.rrtoyewx.newandroid.data.SplashImage;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Rrtoyewx on 16/7/6
 * splash activity 的presenter.
 */
public class SplashPresenter implements SplashContract.Presenter {
    private SplashContract.View splashView;
    private SplashImage splashImage;

    public SplashPresenter() {
        splashImage = new SplashImage.SplashImageFactory().newInstance(SplashImage.DISPLAY_SHOW_LOCAL_IF_HAVE);
    }

    @Override
    public void requestImageUrl() {
        splashImage.getSplashImageBean()
                .doOnSubscribe(() -> splashView.loading())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(imageBean -> {
                            splashView.displayImage(imageBean.getImg());
                            splashImage.saveSplashImageBean(imageBean);
                        }
                        , throwable -> splashView.showErrorMessage(throwable.getMessage()));
    }

    @Override
    public void attach(SplashContract.View view) {
        splashView = view;
    }


    public static class SplashPresenterFactory {
        public SplashPresenter newSplashPresenterInstance() {
            return new SplashPresenter();
        }
    }
}
