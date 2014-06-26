package com.example.helloworld;
import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;


public class SoundDemo extends Activity implements OnClickListener, OnLongClickListener{

	SoundPool sp;
	MediaPlayer mp;
	int soundeffect = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		View v = new View(this);
		v.setOnClickListener(this);
		v.setOnLongClickListener(this);
		setContentView(v);
		
		//use SoundPool for short sounds like button presses
		sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
		soundeffect = sp.load(this, R.raw.buttonpress, 0);
		
		//use MediaPlayer for longer sounds like songs
		mp = MediaPlayer.create(this, R.raw.longclick);
	}

	@Override
	public void onClick(View arg0) {
		if(soundeffect != 0)
			sp.play(soundeffect, 1, 1, 0, 0, 1);
	}

	@Override
	public boolean onLongClick(View v) {
		mp.start();
		return false;
	}

}
