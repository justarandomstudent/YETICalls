package com.etiyeti.yeticalls.login;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.etiyeti.yeticalls.R;

import java.util.Timer;

public class BeginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin);
        final Intent intent = new Intent(this, LoginActivity.class);

        Handler handler = new Handler(Looper.getMainLooper());

        handler.postDelayed(new Runnable() {
            public void run() {
                startActivity(intent);
            }
        }, 3000);
    }
}
