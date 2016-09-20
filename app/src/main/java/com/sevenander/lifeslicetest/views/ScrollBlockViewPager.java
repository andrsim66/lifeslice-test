package com.sevenander.lifeslicetest.views;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class ScrollBlockViewPager extends ViewPager {

    private boolean scrollEnabled = true;

    public ScrollBlockViewPager(Context context) {
        super(context);
    }

    public ScrollBlockViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return this.scrollEnabled && super.onTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return this.scrollEnabled && super.onInterceptTouchEvent(event);
    }

    public void setScrollEnabled(boolean scrollEnabled) {
        this.scrollEnabled = scrollEnabled;
    }
}