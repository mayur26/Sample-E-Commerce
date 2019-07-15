package com.sushant.sampleecommerce.base;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.sushant.sampleecommerce.R;
import com.sushant.sampleecommerce.network.RetrofitApi;
import com.sushant.sampleecommerce.network.RetrofitClient;

public class CommonData {

    private static RetrofitApi apiInterface;
    private static RequestOptions requestOptions;


    public static void showToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static RetrofitApi getApiInstance(Context applicationContext) {
        if (apiInterface == null)
            apiInterface = RetrofitClient.getRetrofitClient(applicationContext).create(RetrofitApi.class);
        return apiInterface;
    }

    public static void setListingImage(final Context context, final String imageUri, final ImageView image, final ProgressBar progressBar, String unavailImage) {
        progressBar.setVisibility(View.VISIBLE);
        try {
            Glide.with(context)
                    .setDefaultRequestOptions(getRequestOptionsListing())
                    .load(imageUri)
                    .thumbnail(0.05f)
                    .listener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                            progressBar.setVisibility(View.GONE);
                            Picasso.with(context).load(imageUri)
                                    .error(R.drawable.unavail_img)
                                    .into(image, new Callback() {
                                        @Override
                                        public void onSuccess() {
                                            progressBar.setVisibility(View.GONE);
                                        }

                                        @Override
                                        public void onError() {

                                            progressBar.setVisibility(View.GONE);
                                        }
                                    });
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, com.bumptech.glide.load.DataSource dataSource, boolean isFirstResource) {
                            progressBar.setVisibility(View.GONE);
                            return false;
                        }
                    })
                    .into(image);
        } catch (Exception | Error e) {
            e.printStackTrace();
            progressBar.setVisibility(View.GONE);
        }
    }


    private static RequestOptions getRequestOptionsListing() {

        if (requestOptions == null) {
            requestOptions = new RequestOptions();
//            requestOptions.error(R.drawable.unavail_img);
            requestOptions.apply(requestOptions.onlyRetrieveFromCache(true));
            requestOptions.diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);
        }
        return requestOptions;
    }


}
