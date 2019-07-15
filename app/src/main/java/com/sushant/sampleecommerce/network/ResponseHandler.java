package com.sushant.sampleecommerce.network;


import com.sushant.sampleecommerce.base.AppConfig;

/**
 * Created by Pranav on 11 July 2017 @ 12:51 PM IST
 */

public interface ResponseHandler {
    void onSuccess(String response, AppConfig.ApiType type);

    void onError(String message, AppConfig.ApiType type);
}