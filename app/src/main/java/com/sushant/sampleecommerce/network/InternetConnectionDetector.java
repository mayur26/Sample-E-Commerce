package com.sushant.sampleecommerce.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.IOException;

public class InternetConnectionDetector {

    private static InternetConnectionDetector icd;
    private Context _context;

    public InternetConnectionDetector(Context context) {
        this._context = context;
    }

    public static InternetConnectionDetector getSingletonDetector(Context context) {

        if (icd == null) {
            icd = new InternetConnectionDetector(context);
        }
        return icd;
    }

    public boolean isConnectingToInternet() {
        ConnectivityManager connectivity = (ConnectivityManager) _context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++)
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
        }
        return false;
    }

    public boolean isInternetWorking() {

        Runtime runtime = Runtime.getRuntime();
        try {

            Process ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8");
            int exitValue = ipProcess.waitFor();
            // showLog("exit value===", "===" + exitValue);
            return (exitValue == 0);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        return false;
    }

}