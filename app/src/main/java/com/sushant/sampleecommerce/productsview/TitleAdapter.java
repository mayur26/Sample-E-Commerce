package com.sushant.sampleecommerce.productsview;

import android.app.Activity;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sushant.sampleecommerce.R;
import com.sushant.sampleecommerce.productsview.model.ProductDetailsModel;

import java.util.List;

/**
 * Created by SushantP on 01/08/2018 @ 11:28 IST
 */

public final class TitleAdapter extends RecyclerView.Adapter {


    Activity context;
    List<ProductDetailsModel.Data> listData;
    String orderId;

    public TitleAdapter(Activity activity, List<ProductDetailsModel.Data> data) {
        this.context = activity;
        this.listData = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_title, null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ViewHolder vh = ((ViewHolder) holder);

        vh.tvDateValue.setText(/*String.valueOf(listData.get(position).getDate())*/"Features");

        vh.rvOrderHistoryDetails.setAdapter(new ProductDetailsAdapter(context, listData.get(position).getFeatured()));

    }

    @Override
    public int getItemCount() {
        return listData.size();
//        return 2;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvDateLable, tvDateValue, tvOrderIdValue, tvOldDetails;
        public RecyclerView rvOrderHistoryDetails;

        public ViewHolder(View v) {
            super(v);

            tvDateValue = v.findViewById(R.id.tv_date_value);
            tvOrderIdValue = v.findViewById(R.id.tv_order_id);
            rvOrderHistoryDetails = v.findViewById(R.id.rv_history_details);
            GridLayoutManager g = new GridLayoutManager(context, 2);
            rvOrderHistoryDetails.addItemDecoration(new GridSpacingItemDecoration(2, 2, true));
            rvOrderHistoryDetails.setLayoutManager(g);

        }
    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

}
