package com.dev.wonn.loopviewpagerwithindicator;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.rd.PageIndicatorView;


public class MainActivity extends AppCompatActivity {
    LoopViewPager vp_viewPager;
    PageIndicatorView rbIndicator;

    int[] images = new int[] {
            R.drawable.test1,
            R.drawable.test2,
            R.drawable.test3,
            R.drawable.test4
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vp_viewPager = findViewById(R.id.vp_viewPager);
        vp_viewPager.setAdapter(new PagerAdapter() {

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView iv_viewPager = new ImageView(container.getContext());
                iv_viewPager.setScaleType(ImageView.ScaleType.CENTER_CROP);
                Glide.with(getApplicationContext()).load(images[position]).into(iv_viewPager);
                container.addView(iv_viewPager);
                rbIndicator.setSelected(LoopViewPager.toRealPosition(position, images.length));
                return iv_viewPager;
            }

            @Override
            public int getCount() {
                return images.length;
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view == object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }
        });

        rbIndicator = findViewById(R.id.rbIndicator);
        rbIndicator.setCount(images.length);

    }
}
