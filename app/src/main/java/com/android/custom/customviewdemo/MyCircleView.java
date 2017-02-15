package com.android.custom.customviewdemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class MyCircleView extends View {
    int bg_color;
    Paint paint;
    int mWidth, mHeight;

    public MyCircleView(Context context) {
        this(context, null);
    }

    public MyCircleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyCircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyCircleView);
        bg_color = typedArray.getColor(R.styleable.MyCircleView_bg_color, Color.GRAY);
        typedArray.recycle();
        init();
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(bg_color);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        mHeight = getHeight();
        mWidth = getWidth();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(new RectF(mWidth / 2 - 100, mWidth / 2 - 100, mWidth / 2 + 100, mWidth / 2 + 100), 0, 360, false, paint);
    }
}
