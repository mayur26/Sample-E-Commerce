package com.sushant.sampleecommerce.network;

import android.content.Context;


import com.sushant.sampleecommerce.R;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient
{

    private static Retrofit retrofit = null;

    public static Retrofit getRetrofitClient(Context context) {
        if (retrofit == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor)
                    .connectTimeout(90, TimeUnit.SECONDS)
//                    .writeTimeout(TIMEOUT_VAL, TimeUnit.SECONDS)
//                    .readTimeout(120, TimeUnit.SECONDS)
                    .retryOnConnectionFailure(true)
                    .build();

            String baseUrl = context.getResources().getString(R.string.main_url);
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
