package com.example.mathgame;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.google.android.material.tabs.TabLayout;

public class FragmentAdapters extends FragmentPagerAdapter {
    private Context context;

    public FragmentAdapters(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new PlusFragment();
        } else if (position == 1) {
            return new SubFragment();
        } else if (position == 2) {
            return new MultiFragment();
        } else {
            return new DevFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0)
            return "COLLECT";
        else if (position == 1)
            return "SUBTRACT";
        else if (position == 2)
            return "MULTIPLY";
        else
            return "DIVISION";
    }


}
