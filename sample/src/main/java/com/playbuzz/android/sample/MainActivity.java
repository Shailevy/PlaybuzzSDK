package com.playbuzz.android.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.playbuzz.android.sdk.PlaybuzzWebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PlaybuzzWebView pbWebView = (PlaybuzzWebView) findViewById(R.id.pbwebview);
        pbWebView.loadItem("http://www.example.com",
                "shpaltman/10-best-commercials-for-the-olympic-games-rio-2016",
                true);
    }
}
