package com.xfinity.vistest;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;

public class InsetReportingFrameLayout extends FrameLayout {
    Rect insets;
    MainActivity.OnInsetsChangedListener onInsetsChangedListener;

    public InsetReportingFrameLayout(final Context context) {
        super(context);
    }

    public InsetReportingFrameLayout(final Context context, final AttributeSet attrs) {
        super(context, attrs);
    }

    public InsetReportingFrameLayout(final Context context, final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public InsetReportingFrameLayout(final Context context, final AttributeSet attrs, final int defStyleAttr, final int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected boolean fitSystemWindows(final Rect insets) {
        Log.d("Insets", insets.toString());
        this.insets = insets;
        if (onInsetsChangedListener != null) {
            onInsetsChangedListener.onInsetsChanged(insets);
        }

        return super.fitSystemWindows(insets);
    }

    public void setOnInsetsChangedListener(final MainActivity.OnInsetsChangedListener onInsetsChangedListener) {
        this.onInsetsChangedListener = onInsetsChangedListener;
    }
}
