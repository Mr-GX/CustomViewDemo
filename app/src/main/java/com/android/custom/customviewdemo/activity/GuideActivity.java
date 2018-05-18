package com.android.custom.customviewdemo.activity;

import android.os.Bundle;

import com.android.custom.customviewdemo.R;
import com.github.paolorotolo.appintro.AppIntro2;
import com.github.paolorotolo.appintro.AppIntroFragment;

public class GuideActivity extends AppIntro2 {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addSlide(AppIntroFragment.newInstance("1", "1", R.mipmap.ic_launcher, R.color.colorAccent));
        addSlide(AppIntroFragment.newInstance("2", "2", R.mipmap.ic_launcher, R.color.colorAccent));
        setProgressButtonEnabled(false);
        setVibrate(true);
        setVibrateIntensity(30);
    }
}
