package com.rq.golfscorecard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rq.golfscorecard.adapters.ListAdapter;
import com.rq.golfscorecard.model.Hole;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    public Hole[] holes = new Hole[18]; // 高爾夫球的 18 洞
    @BindView(R.id.recyclerView) RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        int strokes = 0;
        for (int i = 0; i < holes.length; i += 1) {
            holes[i] = new Hole("Hole " + (i + 1) + " :", strokes);
        }

        ListAdapter adapter = new ListAdapter(this, holes);
        recyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

//        recyclerView.setHasFixedSize(true);

    }
}
