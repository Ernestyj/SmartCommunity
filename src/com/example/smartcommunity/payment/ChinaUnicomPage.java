package com.example.smartcommunity.payment;

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

public class ChinaUnicomPage extends Activity {
	WebView chinaunicomView;
	WebSettings cuSettings;

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_china_unicom_page);
		
		chinaunicomView = (WebView)findViewById(R.id.chinaunicompage);
		chinaunicomView.loadUrl("http://wap.10010.com");
		chinaunicomView.setWebViewClient(new WebViewClient());
		cuSettings = chinaunicomView.getSettings();
		cuSettings.setJavaScriptEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.china_unicom_page, menu);
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
