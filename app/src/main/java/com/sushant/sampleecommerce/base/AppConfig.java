package com.sushant.sampleecommerce.base;

/**
 * Created by SushantP on 12-06-2019
 */

public final class AppConfig {
    private static final AppConfig ourInstance = new AppConfig();

    private AppConfig() {
    }

    public static AppConfig getConstant(){
        return ourInstance;
    }

    public enum ApiType {
        FETCHDATA
    }

}
