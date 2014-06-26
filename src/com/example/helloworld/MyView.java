package com.example.helloworld;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.Paint.Align;
import android.view.View;


public class MyView extends View{

	Bitmap ball;
	float changingY;
	Typeface font;
	
	public MyView(Context context) {
		super(context);
		ball = BitmapFactory.decodeResource(getResources(), R.drawable.tennisball);
		changingY = 0;
		
		font = Typeface.createFromAsset(context.getAssets(), "Lora-Regular.ttf");
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		canvas.drawColor(Color.WHITE);
		
		Paint textpaint = new Paint();
		textpaint.setARGB(50, 50, 150, 50);
		textpaint.setTextAlign(Align.CENTER);
		textpaint.setTextSize(80);
		textpaint.setTypeface(font);
		
		canvas.drawText("helloworld", canvas.getWidth()/2, 200, textpaint);
		canvas.drawBitmap(ball, canvas.getWidth()/2, changingY, null);
		
		if(changingY < canvas.getHeight()){
			changingY += 10;
			//Log.i("EEE", "ball should move +10");
		}else{
			changingY = 0;
		}
		
//		Rect middlerectangle = new Rect();
//		middlerectangle.set(0, 400, canvas.getWidth(), 550);
//		Paint bluepaint = new Paint();
//		bluepaint.setColor(Color.BLUE);
//		canvas.drawRect(middlerectangle, bluepaint);
		
		invalidate();
	}
	
	
	
	
}
