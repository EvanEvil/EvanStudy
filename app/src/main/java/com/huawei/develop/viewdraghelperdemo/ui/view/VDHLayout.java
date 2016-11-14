package com.huawei.develop.viewdraghelperdemo.ui.view;

import android.content.Context;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by Evan on 2016/10/13.
 */
public class VDHLayout extends LinearLayout {

    private ViewDragHelper mViewDragHelp;

    public VDHLayout(Context context) {
        super(context);
    }

    public VDHLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mViewDragHelp = ViewDragHelper.create(this,1.0f, new ViewDragHelper.Callback() {
             @Override
             public boolean tryCaptureView(View child, int pointerId) {
                 return true;
             }

             @Override
             public int clampViewPositionHorizontal(View child, int left, int dx) {
                 int leftBound = getPaddingLeft();
                 int rightPosition = getWidth()-child.getWidth() ;
                 int newLeft = Math.min(Math.max(left,leftBound),rightPosition);

                 return newLeft;
             }

             @Override
             public int clampViewPositionVertical(View child, int top, int dy) {
                 int topBound = getPaddingTop();
                 int bottomBound = getHeight() - child.getHeight();
                 int newTop = Math.min(Math.max(top,topBound),bottomBound);
                 return newTop;
             }
         });
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return mViewDragHelp.shouldInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mViewDragHelp.processTouchEvent(event);
        return true;
    }
}
