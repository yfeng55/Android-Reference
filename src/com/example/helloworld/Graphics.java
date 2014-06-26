package com.example.helloworld;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.support.v4.content.WakefulBroadcastReceiver;


public class Graphics extends Activity{

	MyView animationview;
	PowerManager pm;
	WakeLock wl;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
		wl = (WakeLock) pm.newWakeLock(PowerManager.FULL_WAKE_LOCK, "whatever");
		wl.acquire();
		
		super.onCreate(savedInstanceState);
		
		animationview = new MyView(this);
		setContentView(animationview);
	}

	@Override
	protected void onPause() {
		wl.release();
		super.onPause();
	}
	
	
	
}
