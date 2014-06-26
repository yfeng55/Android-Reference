package com.example.helloworld;
import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;


public class Camera extends Activity implements View.OnClickListener{

	//declare variables
	ImageView picturedisplay;
	ImageButton takepicture;
	Button setwallpaper;
	Bitmap bmp_image;
	
	final static int cameraRequest = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		setContentView(R.layout.camera);
		setViewObjects();
		
		takepicture.setOnClickListener(this);
		setwallpaper.setOnClickListener(this);
		
		InputStream is = getResources().openRawResource(R.drawable.ic_launcher);
		bmp_image = BitmapFactory.decodeStream(is);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.ib_takepicture:
			Intent cameraintent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(cameraintent, cameraRequest);
			break;
		case R.id.b_setwallpaper:
			try {
				getApplicationContext().setWallpaper(bmp_image);
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		}
		
	}
	
	
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode == RESULT_OK){
			Bundle cameradata = data.getExtras();
			bmp_image = (Bitmap) cameradata.get("data");
			picturedisplay.setImageBitmap(bmp_image);
		}

	}
	

	private void setViewObjects(){
		picturedisplay = (ImageView) findViewById(R.id.iv_picture);
		takepicture = (ImageButton) findViewById(R.id.ib_takepicture);
		setwallpaper = (Button) findViewById(R.id.b_setwallpaper);
	}
	
	
}
