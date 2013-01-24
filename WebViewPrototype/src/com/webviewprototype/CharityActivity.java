package com.webviewprototype;

import android.os.Build;
import android.os.Bundle; 
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TextureView;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class CharityActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_charity);
		// Show the Up button in the action bar.
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB){
		getActionBar().setDisplayHomeAsUpEnabled(true);
		}
		Intent intent = getIntent();
		String name = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
		TextView view = (TextView) findViewById(R.id.textView1);
		view.setTextSize(20);
		view.setText(name);
		WebView myWebView = (WebView) findViewById(R.id.webview);
		WebSettings webSettings = myWebView.getSettings();
		webSettings.setJavaScriptEnabled(true);
		myWebView.setWebViewClient(new WebViewClient(){
			 @Override
		        public boolean shouldOverrideUrlLoading(final WebView view, final String url) {
		            return super.shouldOverrideUrlLoading(view, url);
		        }
		});
		myWebView.loadUrl("http://www.google.com");

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_charity, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:

			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
