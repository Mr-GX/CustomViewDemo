package com.android.custom.customviewdemo;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;

public class MyCustomView extends View {
    int custom_color, custom_size;
    boolean custom_anim;
    float scale = 1f;

    public MyCustomView(Context context) {
        this(context, null);
    }

    public MyCustomView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyCustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyCustomView);

        custom_color = typedArray.getColor(R.styleable.MyCustomView_background_color, Color.GRAY);
        custom_size = typedArray.getDimensionPixelSize(R.styleable.MyCustomView_size, 50);
        custom_anim = typedArray.getBoolean(R.styleable.MyCustomView_auto_anim, false);

        typedArray.recycle();
        init();
    }

    Paint mPaint;

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(custom_color);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        if (custom_anim)
            startAnim();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int measureWidth, measureHeight;
        if (widthMode == MeasureSpec.EXACTLY)
            measureWidth = widthSize;
        else
            measureWidth = custom_size;

        if (heightMode == MeasureSpec.EXACTLY)
            measureHeight = heightSize;
        else
            measureHeight = custom_size;

        setMeasuredDimension(measureWidth, measureHeight);
    }

    int mWidth, mHeight;

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        mWidth = getWidth();
        mHeight = getHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(mWidth / 2, mHeight / 2, custom_size * scale, mPaint);
    }

    ValueAnimator mAnimator;

    private void startAnim() {
        mAnimator = ValueAnimator.ofFloat(0, 1, 0);
        mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                scale = (float) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        mAnimator.setDuration(5000);
        mAnimator.setRepeatCount(-1);
        mAnimator.setRepeatMode(ValueAnimator.REVERSE);
        mAnimator.start();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (mAnimator != null)
            mAnimator.end();
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        return super.onSaveInstanceState();
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        super.onRestoreInstanceState(state);
    }
}
