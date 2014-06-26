package com.example.helloworld;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Email extends Activity implements View.OnClickListener{

	//declare variables
	EditText email, intro, name, thing, action, outro;
	String email_text, intro_text, name_text, thing_text, action_text, outro_text;
	Button sendbutton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.email);
		
		setViewObjects();
		
		sendbutton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		
		Log.i("EMAIL_ACTIVITY", "message sent!");
		
		//store text from EditText fields into corresponding String variables
		email_text = getStringFromEditText(email);
		intro_text = getStringFromEditText(intro);
		name_text = getStringFromEditText(name);
		thing_text = getStringFromEditText(thing);
		action_text = getStringFromEditText(action);
		outro_text = getStringFromEditText(outro);
		
		String recipients[] = {email_text};
		String message = "Hello "
				+ name_text
				+ ", I'm emailing you to "
				+ intro_text
				+ ".  I was wondering if you could  "
				+ thing_text
				+ ".  In 3 months I will be "
				+ action_text
				+ ".  Thank you for your time and "
				+ outro_text
				+ ".  \n\n -Yijie Feng";
		
		Intent emailintent = new Intent(android.content.Intent.ACTION_SEND);
		emailintent.putExtra(android.content.Intent.EXTRA_EMAIL, recipients);
		emailintent.putExtra(android.content.Intent.EXTRA_SUBJECT, "hello world");
		emailintent.setType("plain/text");
		emailintent.putExtra(android.content.Intent.EXTRA_TEXT, message);
		startActivity(emailintent);
	}

	private void setViewObjects(){
		email = (EditText) findViewById(R.id.email);
		intro = (EditText) findViewById(R.id.intro);
		name = (EditText) findViewById(R.id.name);
		thing = (EditText) findViewById(R.id.thing);
		action = (EditText) findViewById(R.id.action);
		outro = (EditText) findViewById(R.id.outro);
		
		sendbutton = (Button) findViewById(R.id.sendbutton);
		
	}
	
	private String getStringFromEditText(EditText e){
		String edittext_string;
		edittext_string = e.getText().toString();
		return edittext_string;
	}
	
	
	
	
}
