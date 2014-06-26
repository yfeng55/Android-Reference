package com.example.helloworld;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Data extends Activity implements View.OnClickListener{

	Button start, startForResult;
	EditText questionfield;
	TextView result;
	String question_text;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//get values from preferences
		SharedPreferences sharedprefs = PreferenceManager.getDefaultSharedPreferences(this);
		String name_pref = sharedprefs.getString("name", "Yijie");
		String option_pref = sharedprefs.getString("list", "5");
		
		setContentView(R.layout.get);
		setViewObjects();
		
		//if option 1 is selected in preferences, then display a name as the default value
		if(option_pref.contentEquals("1") == true){
			result.setText(name_pref);
		}
		
		start.setOnClickListener(this);
		startForResult.setOnClickListener(this);
	}
	
	

	@Override
	public void onClick(View v) {
		
		question_text = questionfield.getText().toString();
		//Log.i("questiontext output", question_text);
		Bundle b = new Bundle();
		b.putString("key", question_text);
		
		switch(v.getId()){
		case R.id.b_startActivity:
			
			Intent i = new Intent(this, OpenedClass.class);
			i.putExtras(b);
			startActivity(i);
			
			break;
		case R.id.b_startActivityForResult:
			
			Intent j = new Intent(this, OpenedClass.class);
			j.putExtras(b);
			startActivityForResult(j, 0);
			
			break;
		}
		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		if(resultCode == RESULT_OK){
			
			result.setText(data.getExtras().getString("result"));
		}
		
	}

	private void setViewObjects(){
		start = (Button) findViewById(R.id.b_startActivity);
		startForResult = (Button) findViewById(R.id.b_startActivityForResult);
		questionfield = (EditText) findViewById(R.id.send_field);
		result = (TextView) findViewById(R.id.tv_result);
	
	}
}

