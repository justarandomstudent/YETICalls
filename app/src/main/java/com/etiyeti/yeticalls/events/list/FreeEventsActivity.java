package com.etiyeti.yeticalls.events.list;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telecom.Call;
import android.view.View;
import com.zingaya.voximplant.VoxImplantCallback;
import com.zingaya.voximplant.VoxImplantClient;
import com.zingaya.voximplant.VoxImplantClient.LoginFailureReason;

//import com.zingaya.voximplant.demo.CallActivity;

import com.etiyeti.yeticalls.R;

public class FreeEventsActivity extends AppCompatActivity {
   // private static final int CONTENT_VIEW_ID = 10101010;
    private VoxImplantClient client;
    private Call activeCall = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/*
        client = VoxImplantClient.instance();
        loginInput = (TextView)findViewById(R.id.loginInput);
		passwordInput = (TextView)findViewById(R.id.passwordInput);
		remoteNumberInput = (TextView)findViewById(R.id.callToInput);
        client.setAndroidContext(getApplicationContext());
        client.setCallback(this);*/

        if (savedInstanceState == null) {
            Fragment newFragment = new ItemEvent();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.add(android.R.id.content, newFragment, "MyFragmentTag").commit();
        }
    }
}
