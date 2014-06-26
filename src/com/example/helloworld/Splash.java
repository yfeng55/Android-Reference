package com.example.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class Splash extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
		boolean showsplash = prefs.getBoolean("checkbox", true);
		
		if(showsplash == true){
			setContentView(R.layout.splash);
			
			Thread timer = new Thread(){
				public void run(){
					try{
						sleep(1000);
					}catch(InterruptedException e){
						e.printStackTrace();
					}finally{
						
						//Intent i = new Intent("android.intent.action.MAINACTIVITY"); 					
						Intent i = new Intent(Splash.this, Menu.class);
						startActivity(i);
					}
				}
			};
			timer.start();
		}
		else{
			Intent i = new Intent(this, Menu.class);
			startActivity(i);
		}
		
		
	}
	
	@Override
	protected void onPause(){
		super.onPause();
		
		//closes the Activity
		finish();
	}

}
