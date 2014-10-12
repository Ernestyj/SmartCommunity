package com.example.smartcommunity.ui;

import com.example.smartcommunity.R;
import com.example.smartcommunity.R.id;
import com.example.smartcommunity.R.layout;
import com.example.smartcommunity.R.menu;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ChinaTelecomPage extends Activity {
	WebView ctWebView;
	WebSettings ctSettings;

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_china_telecom);
		
		ctWebView = (WebView)findViewById(R.id.chinatelecompage);
		ctWebView.loadUrl("http://wap.ct10000.com");
		ctWebView.setWebViewClient(new WebViewClient());
		
		ctSettings = ctWebView.getSettings();
		ctSettings.setJavaScriptEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.china_telecom, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
