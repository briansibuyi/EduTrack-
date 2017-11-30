package com.example.poison101.edutrack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class Wesite extends AppCompatActivity {

    public WebView myWe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wesite);

        myWe = (WebView)findViewById(R.id.MyWebView);

        myWe.getSettings().setJavaScriptEnabled(true);
        myWe.setWebChromeClient(new WebChromeClient());
        myWe.loadUrl("file:///android_asset/www/report.html");
    }
}
