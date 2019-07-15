package com.sushant.sampleecommerce;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;
import com.sushant.sampleecommerce.base.AppConfig;
import com.sushant.sampleecommerce.network.NetworkProcessor;
import com.sushant.sampleecommerce.network.ResponseHandler;
import com.sushant.sampleecommerce.productsview.ProductDetailsAdapter;
import com.sushant.sampleecommerce.productsview.model.ProductDetailsModel;
import com.sushant.sampleecommerce.utils.ScrollingPageradaper;
import com.sushant.sampleecommerce.utils.autoscrollviewpager.AutoScrollViewPager;
import com.sushant.sampleecommerce.utils.autoscrollviewpager.CirclePageIndicator;

import java.util.ArrayList;
import java.util.Timer;

import static com.sushant.sampleecommerce.base.CommonData.getApiInstance;
import static com.sushant.sampleecommerce.base.CommonData.showToast;

public class MainActivity extends AppCompatActivity implements ResponseHandler{

    RecyclerView rvFeatured, rvNewArrivals, rvBestSellers;
    LinearLayout llFeatured, llNewArrivals, llBestSellers;
    BottomBar bottomBar;
    ImageView ivKids, ivMen;
    TextView tvTop;

    AutoScrollViewPager loginViewPager;
    CirclePageIndicator pagerIndicator;
    private Timer timer;
    private int currentPage = -1;
    private int NUM_PAGES = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llFeatured = findViewById(R.id.ll_featured);
        llNewArrivals = findViewById(R.id.ll_new_arrivals);
        llBestSellers = findViewById(R.id.ll_best_sellers);
        rvFeatured = findViewById(R.id.rv_featured);
        rvNewArrivals = findViewById(R.id.rv_new_arrivals);
        rvBestSellers = findViewById(R.id.rv_best_sellers);
//        rvPopularSearches = findViewById(R.id.rv_popular_searches);

        bottomBar = findViewById(R.id.bottom_bar);
        ivKids = findViewById(R.id.iv_kids);
        ivMen = findViewById(R.id.iv_men);
        tvTop = findViewById(R.id.tv_top);

        NetworkProcessor
                .getInstance(this)
                .networkCall(getApiInstance(getApplicationContext()).getData("en","KW"),
                        this,
                        AppConfig.ApiType.FETCHDATA);

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId){
                    case R.id.tab_home:
                        Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_LONG).show();
                        break;

                    case R.id.tab_shop:
                        Toast.makeText(getApplicationContext(), "Shop", Toast.LENGTH_LONG).show();
                        break;

                    case R.id.tab_brands:
                        Toast.makeText(getApplicationContext(), "Brands", Toast.LENGTH_LONG).show();
                        break;

                    case R.id.tab_wishlist:
                        Toast.makeText(getApplicationContext(), "Wishlist", Toast.LENGTH_LONG).show();
                        break;

                    case R.id.tab_me:
                        Toast.makeText(getApplicationContext(), "Me", Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });

        bottomBar.setOnTabReselectListener(new OnTabReselectListener() {
            @Override
            public void onTabReSelected(@IdRes int tabId) {
//                Toast.makeText(getApplicationContext(), "Comming", Toast.LENGTH_LONG).show();
            }
        });

        setAutoScrollViewpager();
    }

    private void setAutoScrollViewpager() {
        pagerIndicator = findViewById(R.id.indicater);
        loginViewPager = findViewById(R.id.viewPager);
        loginViewPager.setAdapter(new ScrollingPageradaper(MainActivity.this, getListOfImage()));
        pagerIndicator.setViewPager(loginViewPager);
        loginViewPager.setAutoScrollDurationFactor(8);
        loginViewPager.setCurrentItem(++currentPage, true);
        loginViewPager.setCycle(true);
        loginViewPager.startAutoScroll();
    }

    private ArrayList<Integer> getListOfImage() {

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(R.drawable.banner2);
        arrayList.add(R.drawable.banner3);
        arrayList.add(R.drawable.banner2);
        arrayList.add(R.drawable.banner3);

        return arrayList;
    }


    @Override
    public void onSuccess(String response, AppConfig.ApiType type) {

        ProductDetailsModel model;
        model = new Gson().fromJson(response, ProductDetailsModel.class);

        tvTop.setText(model.getData().getNotifyText());
        ivKids.setImageDrawable(getResources().getDrawable(R.drawable.ic_braun));
        ivMen.setImageDrawable(getResources().getDrawable(R.drawable.ic_mens));

        rvFeatured.setAdapter(new ProductDetailsAdapter(MainActivity.this, model.getData().getFeatured()));
        GridLayoutManager g = new GridLayoutManager(this, 2);
        rvFeatured.addItemDecoration(new GridSpacingItemDecoration(2, 2, true));
        rvFeatured.setLayoutManager(g);
        llFeatured.setVisibility(View.VISIBLE);

        rvNewArrivals.setAdapter(new ProductDetailsAdapter(MainActivity.this, model.getData().getNewArrivals()));
        GridLayoutManager gNewArr = new GridLayoutManager(this, 2);
        rvNewArrivals.addItemDecoration(new GridSpacingItemDecoration(2, 2, true));
        rvNewArrivals.setLayoutManager(gNewArr);
        llNewArrivals.setVisibility(View.VISIBLE);

        rvBestSellers.setAdapter(new ProductDetailsAdapter(MainActivity.this, model.getData().getBestSellers()));
        GridLayoutManager gBestSell = new GridLayoutManager(this, 2);
        rvBestSellers.addItemDecoration(new GridSpacingItemDecoration(2, 2, true));
        rvBestSellers.setLayoutManager(gBestSell);
        llBestSellers.setVisibility(View.VISIBLE);

    }

    @Override
    public void onError(String message, AppConfig.ApiType type) {

        showToast(this, "Exception:"+message);

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
