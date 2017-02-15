package com.android.custom.customviewdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
}
