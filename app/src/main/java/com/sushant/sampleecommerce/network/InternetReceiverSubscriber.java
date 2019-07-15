package com.sushant.sampleecommerce.network;

public interface InternetReceiverSubscriber {

    /**
     * get called after internet connection gets on
     */
    void onInternetConnected();

    /**
     * get called after internet connection goes off
     */
    void onInternetDisconnected();
}
