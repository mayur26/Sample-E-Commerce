package com.sushant.sampleecommerce.network;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RetrofitApi {

    @FormUrlEncoded
    @POST("home")
    Call<ResponseBody> getData(@Field("lang") String lang,
                                   @Field("store") String store);

}

