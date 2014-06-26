package com.example.helloworld;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;


public class SimpleBrowser extends Activity implements OnClickListener{
	
	WebView browser;
	Button back_button, forward_button, refresh_button, clear_button, go_button;
	EditText url_field;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.simplebrowser);
		
		browser = (WebView) findViewById(R.id.wv_browser);
		
		//enable JS
		browser.getSettings().setJavaScriptEnabled(true);
		//allow browser to fit page to screen
		browser.getSettings().setLoadWithOverviewMode(true);
		browser.getSettings().setUseWideViewPort(true);
		
		browser.loadUrl("http://www.google.com");
		browser.setWebViewClient(new WebViewClient());
		
		back_button = (Button) findViewById(R.id.b_back);
		forward_button = (Button) findViewById(R.id.b_forward);
		refresh_button = (Button) findViewById(R.id.b_refresh);
		clear_button = (Button) findViewById(R.id.b_clear);
		go_button = (Button) findViewById(R.id.b_go);
		url_field = (EditText) findViewById(R.id.et_url);
		
		//set OnClickListeners
		back_button.setOnClickListener(this);
		forward_button.setOnClickListener(this);
		refresh_button.setOnClickListener(this);
		clear_button.setOnClickListener(this);
		go_button.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		
		switch(v.getId()){
		case R.id.b_go:
			String destination = url_field.getText().toString();
			browser.loadUrl(destination);
			browser.setWebViewClient(new MyWebViewClient());
			break;
		case R.id.b_back:
			if(browser.canGoBack()){
				browser.goBack();
			}
			break;
		case R.id.b_forward:
			if(browser.canGoForward()){
				browser.goForward();
			}
			break;
		case R.id.b_refresh:
			browser.reload();
			break;
		case R.id.b_clear:
			browser.clearHistory();
			break;
		}
		
	}
	
}
