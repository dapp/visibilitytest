package com.xfinity.vistest;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class InsetReportingLinearLayout extends LinearLayout {
    Rect insets;
    public InsetReportingLinearLayout(final Context context) {
        super(context);
    }

    public InsetReportingLinearLayout(final Context context, final AttributeSet attrs) {
        super(context, attrs);
    }

    public InsetReportingLinearLayout(final Context context, final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public InsetReportingLinearLayout(final Context context, final AttributeSet attrs, final int defStyleAttr, final int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected boolean fitSystemWindows(final Rect insets) {
        this.insets = insets;
        return super.fitSystemWindows(insets);
    }

    public Rect getInsets() {
        return insets;
    }
}
