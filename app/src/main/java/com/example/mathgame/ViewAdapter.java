package com.example.mathgame;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class ViewAdapter extends AppCompatActivity {
    static public int POSITION;
    private TabLayout tabLayout;
    TabLayout.OnTabSelectedListener onTabSelectedListener = new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            switch (tab.getPosition()) {
                case 0:
                    tabLayout.setTabTextColors(ContextCompat.getColor(getApplicationContext(), R.color.tabItems), ContextCompat.getColor(getApplicationContext(), R.color.plusBackGround));
                    break;
                case 1:
                    tabLayout.setTabTextColors(ContextCompat.getColor(getApplicationContext(), R.color.tabItems), ContextCompat.getColor(getApplicationContext(), R.color.subBackGround));
                    break;
                case 2:
                    tabLayout.setTabTextColors(ContextCompat.getColor(getApplicationContext(), R.color.tabItems), ContextCompat.getColor(getApplicationContext(), R.color.multiBackGround));
                    break;
                case 3:
                    tabLayout.setTabTextColors(ContextCompat.getColor(getApplicationContext(), R.color.tabItems), ContextCompat.getColor(getApplicationContext(), R.color.devBackGround));
                    break;
            }
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_adapter);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tab);

        FragmentPagerAdapter fragmentPagerAdapter = new FragmentAdapters(this, getSupportFragmentManager());

        viewPager.setAdapter(fragmentPagerAdapter);
        viewPager.setCurrentItem(POSITION);

        if (POSITION == 0)
            tabLayout.setTabTextColors(ContextCompat.getColor(getApplicationContext(), R.color.tabItems), ContextCompat.getColor(getApplicationContext(), R.color.plusBackGround));
        else if (POSITION == 1)
            tabLayout.setTabTextColors(ContextCompat.getColor(getApplicationContext(), R.color.tabItems), ContextCompat.getColor(getApplicationContext(), R.color.subBackGround));
        else if (POSITION == 2)
            tabLayout.setTabTextColors(ContextCompat.getColor(getApplicationContext(), R.color.tabItems), ContextCompat.getColor(getApplicationContext(), R.color.multiBackGround));
        else if (POSITION == 3)
            tabLayout.setTabTextColors(ContextCompat.getColor(getApplicationContext(), R.color.tabItems), ContextCompat.getColor(getApplicationContext(), R.color.devBackGround));

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(onTabSelectedListener);

    }
}
