package com.android.custom.customviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;
import com.tapadoo.alerter.Alerter;

public class MainActivity extends AppCompatActivity {
    LottieAnimationView animationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animationView = (LottieAnimationView) findViewById(R.id.animation_view);
    }

    public void CustomView(View view) {
        startActivity(new Intent(this, CustomViewActivity.class));
    }

    public void CircleView(View view) {
        startActivity(new Intent(this, CircleViewActivity.class));
    }

    public void GuideView(View view) {
        startActivity(new Intent(this, GuideViewActivity.class));
    }

    public void Alerter(View view) {
        Alerter.create(this)
                .setTitle("Alert Title")
                .setText("Alert text...")
                .setBackgroundColor(R.color.colorAccent)
                .setIcon(R.drawable.ic_face)
                .setDuration(1000)
                .show();
    }

    @Override
    public void onStart() {
        super.onStart();
        animationView.setProgress(0f);
        animationView.playAnimation();
    }

    @Override
    public void onStop() {
        super.onStop();
        animationView.cancelAnimation();
    }

}
