package com.example.helloworld;

import java.util.Random;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Textplay extends Activity implements View.OnClickListener{

	//declare variables for View objects
	Button trybutton;
	ToggleButton togglebutton;
	TextView display;
	EditText edittext;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setViewObjects();
		
		//togglebutton onClick: change edittext from password to plain text
		togglebutton.setOnClickListener(this);
		
		//trybutton onClick
		trybutton.setOnClickListener(this);
		
		
	}
	
	
	private void setViewObjects(){
		setContentView(R.layout.text);
		trybutton = (Button) findViewById(R.id.trybutton);
		togglebutton = (ToggleButton) findViewById(R.id.togglebutton);
		display = (TextView) findViewById(R.id.results);
		edittext = (EditText) findViewById(R.id.etCommands);
	}


	@Override
	public void onClick(View v) {
		switch(v.getId()){
		//togglebutton onClick: change edittext from password to plain text
		case R.id.togglebutton:
			if(togglebutton.isChecked()){
				edittext.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
			}else{
				edittext.setInputType(InputType.TYPE_CLASS_TEXT);
			}
			break;
		//trybutton onClick	
		case R.id.trybutton:
			if(edittext.getText().toString().contentEquals("left")){
				display.setGravity(Gravity.LEFT);
			}
			else if(edittext.getText().toString().contentEquals("center")){
				display.setGravity(Gravity.CENTER);
			}
			else if(edittext.getText().toString().contentEquals("right")){
				display.setGravity(Gravity.RIGHT);
			}
			else if(edittext.getText().toString().contentEquals("yellow")){
				display.setTextColor(Color.YELLOW);
			}
			else if(edittext.getText().toString().contentEquals("WTF")){
				display.setText("WTF!!!");
				Random random = new Random();
				display.setTextSize(random.nextInt(75));
				display.setTextColor(Color.rgb(random.nextInt(265), random.nextInt(265), random.nextInt(265)));
				
				switch(random.nextInt(3)){
				case 0:
					display.setGravity(Gravity.LEFT);
					break;
				case 1:
					display.setGravity(Gravity.CENTER);
					break;
				case 2:
					display.setGravity(Gravity.RIGHT);
					break;
				}
				
			}
			else{
				display.setText("invalid");
				display.setGravity(Gravity.CENTER);
				display.setTextSize(12);
				display.setTextColor(Color.BLACK);
			}
			break;
		}
		
	}
	
	
}
