package com.example.helloworld;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.TextView;


public class HttpDemo extends Activity{

	TextView tv_results;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.http_demo);
		tv_results = (TextView) findViewById(R.id.tv_httpresults);
		
		
		new LoadData().execute();
	}
	
	class LoadData extends AsyncTask <String, Void, String>{

		String returned;
		
		@Override
		protected String doInBackground(String... arg0) {
			HttpGetMethod test = new HttpGetMethod();
			
			try{
				returned = test.getData();
			}catch(Exception e){
				e.printStackTrace();
			}
			
			return null;
		}

		@Override
		protected void onPostExecute(String result) {
			
			super.onPostExecute(result);
			tv_results.setText(returned);
		}
			
	}

}












