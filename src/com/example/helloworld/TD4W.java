package com.example.helloworld;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.LinearLayout;


public class TD4W extends Activity{

	Button liljon;
	MediaPlayer mp;
	LinearLayout layout;
	
	final AnimationDrawable drawable = new AnimationDrawable();
	final Handler handler = new Handler();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.td4w);
		
		liljon = (Button) findViewById(R.id.liljon);
		layout  = (LinearLayout) findViewById(R.id.linearlayout1);
		
		//set frames
		drawable.addFrame(new ColorDrawable(Color.RED), 100);
		drawable.addFrame(new ColorDrawable(Color.BLUE), 100);
		drawable.addFrame(new ColorDrawable(Color.YELLOW), 100);
		drawable.addFrame(new ColorDrawable(Color.CYAN), 100);
		drawable.addFrame(new ColorDrawable(Color.GREEN), 100);
		drawable.setOneShot(false);
		
		//set onclick listener
		liljon.setOnTouchListener(new OnTouchListener(){

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch(event.getAction()) {
		        case MotionEvent.ACTION_DOWN:
		        	
		        	handler.postDelayed(new Runnable() {
		    		    @Override
		    		    public void run() {
		    		    	try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
		    		    	layout.setBackgroundDrawable(drawable);
		    		        drawable.start();
		    		    }
		    		}, 100);
		        	
		        	mp = MediaPlayer.create(TD4W.this, R.raw.td4w);
		        	mp.setLooping(true);
		        	mp.start();
		        	
		            break;
		        case MotionEvent.ACTION_UP:
		        	
		        	drawable.stop();		
		        	layout.setBackgroundColor(Color.WHITE);
		        	
		        	mp.stop();
		        	mp.release();
		        	
		        	
		            break;
		        }
				return false;
			}
			
		});
		
		
	}

	
}
