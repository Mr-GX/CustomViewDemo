package com.android.custom.customviewdemo.activity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.ImageView;

import com.android.custom.customviewdemo.R;
import com.android.custom.customviewdemo.view.ProgressView;

import java.util.Random;

public class AnimatorActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator);

        ImageView iv = (ImageView) findViewById(R.id.iv);
        ObjectAnimator animator = ObjectAnimator.ofFloat(iv, "translationX", 500);
        animator.setInterpolator(new AnticipateOvershootInterpolator());
        animator.setRepeatCount(100);
        animator.setDuration(1000L).start();

        ProgressView view = (ProgressView) findViewById(R.id.iv_2);
        ObjectAnimator.ofFloat(view,"progress", (float) Math.random()*100).setDuration(1000L).start();
    }
}
