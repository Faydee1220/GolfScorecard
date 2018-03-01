package com.rq.golfscorecard;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.rq.golfscorecard.adapters.ListAdapter;
import com.rq.golfscorecard.model.Hole;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_FILE = "com.rq.golfscorecard.preferences";
    private static final String PREF_HOLE = "PREF_HOLE";
    @BindView(R.id.recyclerView) RecyclerView recyclerView;

    public Hole[] holes = new Hole[18]; // 高爾夫球的 18 洞
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        sharedPreferences = getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);

        int strokes = 0;
        for (int i = 0; i < holes.length; i += 1) {
            strokes = sharedPreferences.getInt(PREF_HOLE + i + 1, 0);
            holes[i] = new Hole("Hole " + (i + 1) + " :", strokes);
        }

        ListAdapter adapter = new ListAdapter(this, holes);
        recyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setHasFixedSize(true);
    }

    @Override
    protected void onPause() {
        super.onPause();
        editor = sharedPreferences.edit();
        for (int i = 0; i < holes.length; i += 1) {
            editor.putInt(PREF_HOLE + i + 1, holes[i].getStrokeCount());
        }
        editor.apply();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.clearStorkes) {
            for (Hole hole : holes) {
                hole.setStrokeCount(0);
            }
            editor = sharedPreferences.edit();
            editor.clear();
            editor.apply();
            recyclerView.getAdapter().notifyDataSetChanged();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
