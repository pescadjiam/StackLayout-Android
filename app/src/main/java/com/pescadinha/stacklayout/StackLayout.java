package com.pescadinha.stacklayout;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

/**
 * Created by dengun on 31/08/16.
 */
public class StackLayout extends LinearLayout {

    private static final String TAG = "StackLayout";
    private Resources res = getContext().getResources();

    private int layoutOrientation, spacing, distribution;

    private LayoutParams verticalLayoutParams, horizontalLayoutParams;

    private final int HORIZONTAL_ORIENTATION = 0;
    private final int VERTICAL_ORIENTATION = 1;

    public StackLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.StackLayout);

        layoutOrientation = a.getInt(R.styleable.StackLayout_android_orientation, 0);
        spacing = a.getInt(R.styleable.StackLayout_spacing, 0);
        distribution = a.getInt(R.styleable.StackLayout_distribution, 0);
        a.recycle();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

        for (int i = 0 ; i < getChildCount() - 1; i++){
            MarginLayoutParams params = (MarginLayoutParams) getChildAt(i).getLayoutParams();
            if(layoutOrientation == VERTICAL_ORIENTATION){
                params.bottomMargin = spacing;
            } else {
                params.rightMargin = spacing;
            }

        }
    }
}
