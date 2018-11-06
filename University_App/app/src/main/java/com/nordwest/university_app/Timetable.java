package com.nordwest.university_app;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class Timetable extends AppCompatActivity  /* ListActivity implements AdapterView.OnItemClickListener*/ {

/*
    String [] week_day;
*/
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_timetable);
        mWebView = new WebView (this);
        setContentView(mWebView);
        mWebView.setWebViewClient(new WebViewSampleClient());
        mWebView.loadUrl("https://myqahe.qabusinessschool.com/Account/StudentTimetable.aspx");
        mWebView.getSettings().setJavaScriptEnabled(true);

        /*week_day = getResources().getStringArray(R.array.week_days);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.week_day_list, week_day);
        getListView().setAdapter(arrayAdapter);

        getListView().setOnItemClickListener(this);
        Toast.makeText(getBaseContext(),"Timetable",Toast.LENGTH_LONG).show();*/

    }
    public boolean onKeyDown (int keyCode, KeyEvent event){
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()){
            mWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private class WebViewSampleClient extends WebViewClient{
        public boolean shouldOverrideUrlLoading(WebView view, String url){
            view.loadUrl(url);
            return true;
        }
    }

   /* @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, ((TextView) view).getText(), Toast.LENGTH_LONG).show();
    }*/
}