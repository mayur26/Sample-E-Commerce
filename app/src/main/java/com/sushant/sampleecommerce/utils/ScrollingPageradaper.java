package com.sushant.sampleecommerce.utils;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sushant.sampleecommerce.R;

import java.util.ArrayList;


/**
 * Created by SushantP on 12-7-2019.
 */
public class ScrollingPageradaper extends PagerAdapter {

    private final static int[] bannerList = new int[]{R.drawable.banner2, R.drawable.banner3,
            R.drawable.banner2, R.drawable.banner3};
    ArrayList<ViewGroup> views;
    LayoutInflater inflater;
    Context context;
    private ArrayList<Integer> imagesList;

    public ScrollingPageradaper(Context context, ArrayList<Integer> imagesList) {
//
        //instantiate your views list
        views = new ArrayList<ViewGroup>(getSize());

        this.context = context;
        this.imagesList = imagesList;

    }

    private int getSize() {

        return bannerList.length;
    }

    /**
     * To be called by onStop
     * Clean the memory
     */
    public void release() {
        views.clear();
        views = null;
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return getSize();
    }

    public Object instantiateItem(ViewGroup container, int position) {
        ViewGroup currentView = null;

        if (views.size() > position && views.get(position) != null) {
            currentView = views.get(position);
        } else {

            try {
                inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                currentView = (ViewGroup) inflater.inflate(R.layout.row_scrolling_pager, container, false);
                ImageView imageView = currentView.findViewById(R.id.imgView);

                imageView.setImageResource(bannerList[position]);


            } catch (Exception e) {
                Log.e("#Exception", e.toString());
            }
//            imageView.setImageResource(imagesList.get(position));


        }
        container.addView(currentView);
        return currentView;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);

    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }


}
