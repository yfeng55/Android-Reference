package com.example.helloworld;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;


public class GraphicsSurface extends Activity implements OnTouchListener{

	MySurface ourSurfaceView;
	float x, y, sX, sY, fX, fY, dX, dY, aniX, aniY, scaledX, scaledY;
	Bitmap ball, plus;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ourSurfaceView = new MySurface(this);
		ourSurfaceView.setOnTouchListener(this);
		setContentView(ourSurfaceView);
		
		x = y = sX = sY = fX = fY = 0;
		dX = dY = aniX = aniY = scaledX = scaledY = 0;
		
		ball = BitmapFactory.decodeResource(getResources(), R.drawable.tennisball);
		plus = BitmapFactory.decodeResource(getResources(), R.drawable.plussign);
	}

	@Override
	protected void onPause() {
		
		super.onPause();
		ourSurfaceView.pause();
	}

	@Override
	protected void onResume() {
		
		super.onResume();
		ourSurfaceView.resume();
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		
		//sleep for 50 milliseconds to reduce framerate
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		x = event.getX();
		y = event.getY();
		
		switch(event.getAction()){
		case MotionEvent.ACTION_DOWN:
			sX = event.getX();
			sY = event.getY();
			dX = dY = aniX = aniY = scaledX = scaledY = fX = fY = 0;
			break;
		case MotionEvent.ACTION_UP:
			fX = event.getX();
			fY = event.getY();
			dX = fX - sX;
			dY = fY - sY;
			scaledX = dX/30;
			scaledY = dY/30;
			
			x = y = 0;
			break;
		}
		
		return true;
	}

	
	/////////// MySurface class ////////////////
	public class MySurface extends SurfaceView implements Runnable{

		SurfaceHolder sholder;
		Thread th;
		boolean isRunning = false;
		
		public MySurface(Context context){
			super(context);
			sholder = getHolder();
		}

		
		public void pause(){
			isRunning = false;
			while(true){
				try {
					th.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			}
			th = null;
		}
		
		public void resume(){
			isRunning = true;
			th = new Thread(this);
			th.start();
		}
		
		@Override
		public void run() {
			while(isRunning){
				if(!sholder.getSurface().isValid()){
					continue;
				}	
				Canvas canvas = sholder.lockCanvas();
				canvas.drawRGB(35, 200, 35);
				
				if(x != 0 && y != 0){
					canvas.drawBitmap(ball, x-ball.getWidth()/2, y-ball.getHeight()/2, null);
				}
				if(sX != 0 && sY != 0){
					canvas.drawBitmap(plus, sX - plus.getWidth()/2, sY - plus.getHeight()/2, null);
				}
				if(fX != 0 && fY != 0){
					canvas.drawBitmap(ball, (fX - ball.getWidth()/2 - aniX), (fY - ball.getHeight()/2 - aniY), null);
					//canvas.drawBitmap(plus, fX - plus.getWidth()/2, fY - plus.getHeight()/2, null);
				}
				aniX = aniX + scaledX;
				aniY = aniY + scaledY;
				
				sholder.unlockCanvasAndPost(canvas);
			}
		}

	}

	
	
	
	
}
