package com.youku.rrtoyewx.newandroid.net;

import com.youku.rrtoyewx.newandroid.net.constants.UrlConstants;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rrtoyewx on 16/7/6.
 * 配置Retrofit
 */
public class RetrofitManager {
    private static Retrofit sRetrofit;
    private static OkHttpClient sOkHttpClient;

    static {
        initOkHttpClient();
    }

    private static void initOkHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        sOkHttpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(interceptor)
                .build();
    }

    public static void initRetrofitManager() {
        if (sRetrofit == null) {
            synchronized (RetrofitManager.class) {
                if (sRetrofit == null) {
                    sRetrofit = new Retrofit.Builder()
                            .baseUrl(UrlConstants.BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .client(sOkHttpClient)
                            .build();
                }
            }
        }
    }

    public static Retrofit getRetrofitInstance() {
        if (sRetrofit == null) {
            initRetrofitManager();
        }

        return sRetrofit;
    }
}
