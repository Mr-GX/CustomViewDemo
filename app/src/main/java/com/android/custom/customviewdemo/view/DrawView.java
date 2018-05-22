package com.android.custom.customviewdemo.view;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.android.custom.customviewdemo.R;

public class DrawView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public DrawView(Context context) {
        super(context);
    }

    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public DrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void draw(Canvas canvas) {
        //总绘制包括onDraw、dispatchDraw、onDrawForeground
        super.draw(canvas);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //主体绘制
        super.onDraw(canvas);
        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher),100,100,paint);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        //子View绘制
        super.dispatchDraw(canvas);
        paint.setColor(Color.RED);
        canvas.drawCircle(200,100,10,paint);
        paint.setColor(Color.BLACK);
        canvas.drawText("1",197,103,paint);
    }

    @Override
    public void onDrawForeground(Canvas canvas) {
        //前景绘制
        super.onDrawForeground(canvas);
        canvas.drawColor(Color.parseColor("#88880000"), PorterDuff.Mode.ADD);
    }
}
