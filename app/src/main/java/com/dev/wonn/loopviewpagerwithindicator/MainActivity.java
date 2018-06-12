package com.dev.wonn.loopviewpagerwithindicator;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ViewPager vp_viewPager;
    TabLayout tl_indicator;
    Adaptor_ViewPager adaptor_viewPager;
    List<Item_ViewPager> list_viewPager = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vp_viewPager = findViewById(R.id.vp_viewPager);
        tl_indicator = findViewById(R.id.tl_indicator);
        initView();
        adaptor_viewPager = new Adaptor_ViewPager(getApplicationContext(), getLayoutInflater(), list_viewPager);
        vp_viewPager.setAdapter(adaptor_viewPager);
        tl_indicator.setupWithViewPager(vp_viewPager, true);
        tl_indicator.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.i("MainActivity", "onTabSelected: " + tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        vp_viewPager.setOffscreenPageLimit(adaptor_viewPager.getCount());
        vp_viewPager.setCurrentItem(list_viewPager.size());
        vp_viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                int position = vp_viewPager.getCurrentItem();

                if (state == ViewPager.SCROLL_STATE_IDLE
                        && (position == 0 || position == adaptor_viewPager.getCount()-1)) {
                    vp_viewPager.setCurrentItem(adaptor_viewPager
                            .getRealPosition(position, adaptor_viewPager.getCount()), false);
                }
            }
        });
    }

    public void initView() {
        for (int i=0; i<5; i++) {
            list_viewPager.add(new Item_ViewPager(R.drawable.test1, "Pages : " + (i+1)));
        }
    }
}
