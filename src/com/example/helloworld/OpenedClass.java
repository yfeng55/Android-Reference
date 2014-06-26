package com.example.helloworld;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;


public class OpenedClass extends Activity implements View.OnClickListener{
	
	TextView question, test;
	Button returnbutton;
	RadioGroup answerlist;
	String questiontext, resulttext;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.send);
		setViewObjects();
		returnbutton.setOnClickListener(this);
		
		//receive data from calling activity
		Bundle b = getIntent().getExtras();
		questiontext = b.getString("key");		
		question.setText(questiontext);
		
		//set listener for radiogroup
		answerlist.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				
				switch(checkedId){
				case R.id.rb_burger:
					resulttext = "get some exercise afterwards!";
					break;
				case R.id.rb_pizza:
					resulttext = "watch those calories!";
					break;
				case R.id.rb_salad:
					resulttext = "that's a healthy choice!";
					break;
				}
				
				test.setText(resulttext);
			}
		});
		
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.b_return:
			Bundle b = new Bundle();
			b.putString("result", resulttext);
			
			Intent i = new Intent();
			i.putExtras(b);
			
			setResult(RESULT_OK, i);
			finish();
			break;
		}
		
	}
	
	private void setViewObjects(){
		question = (TextView) findViewById(R.id.tv_question);
		test = (TextView) findViewById(R.id.tv_test);
		answerlist = (RadioGroup) findViewById(R.id.rg_answers);
		returnbutton = (Button) findViewById(R.id.b_return);
	}


}
