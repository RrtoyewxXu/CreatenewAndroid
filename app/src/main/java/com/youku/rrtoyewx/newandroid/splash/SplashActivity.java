package com.youku.rrtoyewx.newandroid.splash;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.youku.rrtoyewx.newandroid.R;

public class SplashActivity extends AppCompatActivity implements SplashContract.View {
    private ImageView mSplashImage;
    private ProgressBar mLoadingBar;

    private SplashContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mSplashImage = (ImageView) findViewById(R.id.iv_splash);
        mLoadingBar = (ProgressBar) findViewById(R.id.pb_splash_loading);
        mPresenter = new SplashPresenter.SplashPresenterFactory().newSplashPresenterInstance();
        mPresenter.attach(this);
        mPresenter.requestImageUrl();
    }

    @Override
    public void displayImage(String imageUrl) {
        mLoadingBar.setVisibility(View.GONE);
        mSplashImage.setVisibility(View.VISIBLE);
        Glide.with(this)
                .load(imageUrl)
                .asBitmap()
                .into(mSplashImage);
    }

    @Override
    public void loading() {
        mLoadingBar.setVisibility(View.VISIBLE);
        mSplashImage.setVisibility(View.GONE);
    }

    @Override
    public void showErrorMessage(String message) {
        mSplashImage.setVisibility(View.GONE);
        mLoadingBar.setVisibility(View.GONE);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
