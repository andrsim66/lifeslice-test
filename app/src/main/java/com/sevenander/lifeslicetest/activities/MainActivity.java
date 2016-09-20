package com.sevenander.lifeslicetest.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import com.sevenander.lifeslicetest.R;
import com.sevenander.lifeslicetest.adapters.TabsPagerAdapter;
import com.sevenander.lifeslicetest.fragments.BFragment;
import com.sevenander.lifeslicetest.utils.callbacks.FragmentCallback;
import com.sevenander.lifeslicetest.views.ScrollBlockViewPager;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements FragmentCallback {

    @Bind(R.id.psts_tabs) TabLayout tabLayout;
    @Bind(R.id.vp_tabs_info) ScrollBlockViewPager viewPager;

    private TabsPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupPager();
    }

    private void setupPager() {
        adapter = new TabsPagerAdapter(
                getSupportFragmentManager(), MainActivity.this);
        viewPager.setAdapter(adapter);
        viewPager.setScrollEnabled(false);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onNextClick() {
        ((BFragment) adapter.getItem(1)).refreshList();
        ((BFragment) adapter.getItem(1)).playVideo(0);
        viewPager.setCurrentItem(1, true);
    }
}
