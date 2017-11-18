package com.muxistudio.oneday.net;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by fengminchao on 17/11/18
 */

public class RetrofitAdapter {

    private final RetrofitService mRetrofitService;

    private static class RetrofitAdapterHolder {
        private static final RetrofitAdapter INSTANCE = new RetrofitAdapter();
    }
    private RetrofitAdapter (){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .readTimeout(15, TimeUnit.SECONDS)
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15,TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl("")
                .build();
        mRetrofitService = retrofit.create(RetrofitService.class);
    }

    public static final RetrofitAdapter getInstance() {
        return RetrofitAdapterHolder.INSTANCE;
    }

    public static final RetrofitService getRetrofitService(){
        return RetrofitAdapterHolder.INSTANCE.mRetrofitService;
    }
}
