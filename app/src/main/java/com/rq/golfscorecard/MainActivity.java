package com.rq.golfscorecard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rq.golfscorecard.model.Hole;

public class MainActivity extends AppCompatActivity {

    private Hole[] holes = new Hole[18]; // 高爾夫球的 18 洞

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int strokes = 0;
        for (int i = 0; i < holes.length; i += 1) {
            holes[i] = new Hole("Hole " + (i + 1) + " :", strokes);
        }

    }
}
