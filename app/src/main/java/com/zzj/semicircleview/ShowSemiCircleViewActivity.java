package com.zzj.semicircleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zzj.library.SemiCircleView;

public class ShowSemiCircleViewActivity extends AppCompatActivity {
    private SemiCircleView semiCircleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        semiCircleView = (SemiCircleView) findViewById(R.id.test);
        semiCircleView.setmProgressValue(50);
        semiCircleView.setAnimation(true);
    }
}
