package com.sushant.sampleecommerce.network;

import android.app.Activity;
import android.content.Context;

import com.sushant.sampleecommerce.R;
import com.sushant.sampleecommerce.base.AppConfig;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.sushant.sampleecommerce.base.CommonData.showToast;


/**
 * Created by SushantP on 12-06-2019
 */

@SuppressWarnings("all")
public class NetworkProcessor implements InternetReceiverSubscriber {

    private static NetworkProcessor networkProcessor;
    private static Context context;

    private Call<ResponseBody> Req;

    private NetworkProcessor(Context context) {
        NetworkProcessor.context = context;
    }

    public static NetworkProcessor getInstance(Context context) {
        if (networkProcessor == null)
            networkProcessor = new NetworkProcessor(context);
        return networkProcessor;
    }


    public void networkCall(Call<ResponseBody> request, final ResponseHandler handler, final AppConfig.ApiType apiType) {

        this.Req = request;

        InternetConnectionDetector internetConnectionDetector = new InternetConnectionDetector(context);
        if (internetConnectionDetector.isConnectingToInternet()) {

            Req.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    String res = null;
                    try {
                        if (response.isSuccessful()) {
                            if (response.body() == null) {
                                handler.onError("Server Error" + response.code(), apiType);
                                showToast(context, "Server Error");
                            }
                            else {
                                res = response.body().string();
                                if (res != null)
                                    res = res.trim();

                                if (response.code() != 200 || response.code() == 500 || response.code() == 404 || response.body().toString().isEmpty()) {
                                    // System.out.println("=====ERROR: stp1");
                                    handler.onError("Server Error" + response.code(), apiType);
                                    //showLog("NetworkProcessor Error", "API ------> " + apiType + "\t" + "server error");
                                }
                                else if (response.body() == null || response.body().toString().equalsIgnoreCase("{}")) {
                                    handler.onError("No Response " + response.code(), apiType);
                                    // System.out.println("=====ERROR: stp2");
                                    //showLog("NetworkProcessor Error", "API ------> " + apiType + "\t" + "No response");
                                    if (context != null && !((Activity) context).isFinishing()) {
                                        showToast(context, "Apologies\n Please try again after sometime");
                                    }
                                }
                                else if (response.body().toString().length() == 2 && response.body().toString().equalsIgnoreCase("{}")) {
                                    // System.out.println("=====ERROR: stp3");
                                    handler.onError("Empty list", apiType);
                                    if (context != null && !((Activity) context).isFinishing()) {
                                        showToast(context, "Something went wrong");
                                    }
                                }
                                else if (res != null && !res.trim().isEmpty()) {
                                    try {
                                        if (res.trim().length() == 2 && (res.trim().equals("{}") || res.trim().equals("[]")))
                                            handler.onError("Empty Response", apiType);
                                        else
                                            handler.onSuccess(res, apiType);

                                    }
                                    catch (Exception e) {
                                        //showLog("Error " + this.getClass().getSimpleName(), "" + e.getMessage() + " " + e.getCause());// e.printStackTrace();
                                        handler.onError(context.getResources().getString(R.string.something_went_wrong), apiType);
                                    }

                                }
                                else {

                                    if (!(response.body().contentLength() == -1) || !response.body().toString().isEmpty() || !response.body().equals("")) {
                                        handler.onSuccess(response.body() != null ? response.body().string() : "NULL", apiType);
                                    }
                                    else {
                                        handler.onError("Empty Response", apiType);
                                        if (context != null && !((Activity) context).isFinishing()) {
                                            showToast(context, "Empty response");
                                        }
                                    }
                                }
                            }
                        }
                    }
                    catch (IOException e) {
                        //showLog("Error " + this.getClass().getSimpleName(), "" + e.getMessage() + " " + e.getCause());// e.printStackTrace();
                        handler.onError(context.getResources().getString(R.string.something_went_wrong), apiType);
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
//                spotsDialog.dismiss();

                    // Toast.makeText(context, "Server is Not Responding,Please Try After Sometime.", Toast.LENGTH_SHORT).show();
//                ErrorHandler.getErrorHandler(context, NetworkProcessor.this).showError(t);
//                    handler.onError(t.getMessage().toUpperCase(), apiType);
                    handler.onError("Server is Not Responding,Please Try After Sometime.", apiType);
                }
            });

        }
        else {

            handler.onError("No internet available", apiType);

        }
    }


    public void cancelRequest() {
        if (Req != null) {
            Req.cancel();
        }
    }

    @Override
    public void onInternetConnected() {

    }

    @Override
    public void onInternetDisconnected() {

    }
}
