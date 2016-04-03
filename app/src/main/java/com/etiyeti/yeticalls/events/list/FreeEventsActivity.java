package com.etiyeti.yeticalls.events.list;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.etiyeti.yeticalls.R;

public class FreeEventsActivity extends AppCompatActivity {
    private static final int CONTENT_VIEW_ID = 10101010;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_events);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        if (savedInstanceState == null) {
            Fragment newFragment = new ItemEvent();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.add(android.R.id.content, newFragment, "MyFragmentTag").commit();
        }
    }
}
