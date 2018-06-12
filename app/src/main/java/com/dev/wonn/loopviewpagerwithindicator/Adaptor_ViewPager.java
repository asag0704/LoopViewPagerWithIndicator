package com.dev.wonn.loopviewpagerwithindicator;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adaptor_ViewPager extends PagerAdapter {
    public Context context;
    public LayoutInflater inflater;
    public List<Item_ViewPager> list_viewPager;

    public Adaptor_ViewPager(Context context, LayoutInflater inflater, List<Item_ViewPager> list_viewPager) {
        this.context = context;
        this.inflater = inflater;
        this.list_viewPager = list_viewPager;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = inflater.inflate(R.layout.viewpager_item, container, false);
        ImageView iv_viewPager = view.findViewById(R.id.iv_viewPager);
        TextView tv_viewPager = view.findViewById(R.id.tv_viewPager);

        position %= list_viewPager.size();

        Item_ViewPager item_viewPager = list_viewPager.get(position);
        iv_viewPager.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Glide.with(context).load(item_viewPager.getIv_viewPager()).into(iv_viewPager);
        tv_viewPager.setText(item_viewPager.getTv_viewPager());
        container.addView(view, 0);

        return view;
    }

    public int getRealPosition(int position, int count) {
        if (position == 0) {
            position = list_viewPager.size();
        } else {
            position = list_viewPager.size()-1;
        }
        return position;
    }

    @Override
    public int getCount() {
        return list_viewPager.size() * 3;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }
}
