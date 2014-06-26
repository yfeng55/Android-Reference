package com.example.helloworld;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity{
	
	//define a String array
	String options[] = {"MainActivity", "Textplay", "Email", "Camera", "Data", "TD4W", "Graphics", "GraphicsSurface", "SoundDemo", "SimpleBrowser", "HttpDemo", ""};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//make menu activity full screen
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		//set an adapter for the ListView, takes a ListAdapter as a parameter
		setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, options));
	}
	
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		String menuselection = options[position];
		
		//create a class variable given the position parameter that's passed
		try {
			Class menu_class = Class.forName("com.example.helloworld." + menuselection);
			Intent i = new Intent(Menu.this, menu_class);
			startActivity(i);
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}


	
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
	
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		
		return true;
	}


	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		
		switch(item.getItemId()){
		case R.id.aboutUs:
			Intent i = new Intent(this, AboutUs.class);
			startActivity(i);
			break;
		case R.id.preferences:
			Intent j = new Intent(this, Prefs.class);
			startActivity(j);
			break;
		}
		
		return true;
	}

	
	
}
