package com.android.custom.customviewdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;
import com.android.custom.customviewdemo.R;
import com.tapadoo.alerter.Alerter;

public class MainActivity extends AppCompatActivity {
    LottieAnimationView animationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animationView = (LottieAnimationView) findViewById(R.id.animation_view);
    }

    public void DrawView(View view) {
        startActivity(new Intent(this, DrawViewActivity.class));
    }

    public void GuideView(View view) {
        startActivity(new Intent(this, GuideActivity.class));
    }

    public void AnimatorView(View view) {
        startActivity(new Intent(this, AnimatorActivity.class));
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
