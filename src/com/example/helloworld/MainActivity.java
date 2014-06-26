package com.example.helloworld;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	int counter;
	Button add, sub;
	TextView display;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
			
		counter = 0;
		add = (Button) findViewById(R.id.addbutton);
		sub = (Button) findViewById(R.id.subtractbutton);
		display = (TextView) findViewById(R.id.textView1);
		
		
		add.setOnClickListener(new View.OnClickListener(){
			
			@Override
			public void onClick(View v) {
				counter++;
				display.setText("Your total is: " + counter);
			}
		});
		
		sub.setOnClickListener(new View.OnClickListener(){
			
			@Override
			public void onClick(View v) {
				counter--;
				display.setText("Your total is: " + counter);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


}
