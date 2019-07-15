package com.sushant.sampleecommerce.productsview;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.sushant.sampleecommerce.R;
import com.sushant.sampleecommerce.productsview.model.ProductDetailsModel;

import java.util.List;

import static com.sushant.sampleecommerce.base.CommonData.setListingImage;

/**
 * Created by SushantP on 12-07-2019
 */

public final class ProductDetailsAdapter extends RecyclerView.Adapter {


    Activity ack;
    List<ProductDetailsModel.Data.CommonProduct> listData;

    public ProductDetailsAdapter(Activity activity, List<ProductDetailsModel.Data.CommonProduct> data) {
        this.ack = activity;
        this.listData = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_product_details, null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ViewHolder vh = ((ViewHolder) holder);

        vh.tvProductName.setText(listData.get(position).getBrandName());
        vh.tvProductPrice.setText(listData.get(position).getCurrencyCode() + " " + listData.get(position).getFinalPrice());

        String uri = listData.get(position).getImage();
//        For temporary we added following link if image not available
        String unavailImage = "http://websites.lezasolutions.com/bazma/images/nopreview_thumb.png";

        setListingImage(vh.itemView.getContext(), uri, vh.ivProduct, vh.progressBar, unavailImage);

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView ivProduct;
        public TextView tvProductName, tvProductPrice;
        ProgressBar progressBar;

        public ViewHolder(View v) {
            super(v);

            tvProductName = v.findViewById(R.id.tv_product_name);
            tvProductPrice = v.findViewById(R.id.tv_product_price);
            ivProduct = v.findViewById(R.id.iv_product);
            progressBar = v.findViewById(R.id.progressBar);

        }


    }
}
