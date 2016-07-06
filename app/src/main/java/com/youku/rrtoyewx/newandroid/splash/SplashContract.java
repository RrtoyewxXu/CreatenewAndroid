package com.youku.rrtoyewx.newandroid.splash;

/**
 * Created by Rrtoyewx on 16/7/6.
 * splash contract
 */
public interface SplashContract {
    interface View {
        void displayImage(String imageUrl);

        void loading();

        void showErrorMessage(String message);
    }

    interface Presenter {
        void requestImageUrl();

        void attach(View view);
    }
}
