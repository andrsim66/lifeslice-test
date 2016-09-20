package com.sevenander.lifeslicetest.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.sevenander.lifeslicetest.R;
import com.sevenander.lifeslicetest.fragments.AFragment;
import com.sevenander.lifeslicetest.fragments.BFragment;

public class TabsPagerAdapter extends FragmentPagerAdapter {

    private String[] mTitles;

    public TabsPagerAdapter(FragmentManager fragmentManager, Context context) {
        super(fragmentManager);
        mTitles = new String[2];
        mTitles[0] = context.getResources().getString(R.string.title_tab1);
        mTitles[1] = context.getResources().getString(R.string.title_tab2);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new AFragment();
            default:
                return new BFragment();
        }
    }
}
