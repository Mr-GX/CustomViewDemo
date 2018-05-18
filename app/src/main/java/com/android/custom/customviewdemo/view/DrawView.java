package com.android.custom.customviewdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.android.custom.customviewdemo.R;


public class DrawView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path path = new Path();

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
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(getResources().getColor(R.color.colorBg));
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawCircle(150, 150, 100, paint);
        canvas.drawRect(150, 300, 300, 450, paint);
        canvas.drawRoundRect(150, 500, 300, 650, 50, 50, paint);

        paint.setStyle(Paint.Style.STROKE);
        path.moveTo(600,600);
        path.arcTo(600,600,750,750,-180,180,true);
        path.arcTo(750,600,900,750,-180,180,true);
        path.lineTo(750,825);
        path.lineTo(600,675);
        canvas.drawPath(path,paint);
    }
}