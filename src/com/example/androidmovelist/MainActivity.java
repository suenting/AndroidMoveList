package com.example.androidmovelist;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	public static String EXTRA_MESSAGE = "com.movelist.MESSAGE";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// array values for list view
	    String[] values = new String[] { 
	    		"Ragna", 
	    		"Jin", 
	    		"Noel",
	            "Rachel",
	            "Taokaka",
	            "Tager",
	            "Litchi",
	            "Arakune",
	            "Bang",
	            "Carl",
	            "Hakumen",
	            "Tsubaki",
	            "Hazama",
	            "Makoto",
	            "Valkenhein",
	            "Platnium",
	            "Relius",
	            "Amane",
	            "Bullet",
	            "Azreal",
	            "Nu-13",
	            "Mu-12",
	            "Izayoi",
	            "Kagura",
	            "Terumi",
	            "Kokonoe"};
	    final ArrayList<String> list = new ArrayList<String>();
	    for (int i = 0; i < values.length; ++i) {
	      list.add(values[i]);
	    }
	    
	    // create array adapter for list view
	    ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.list_item,R.id.list_content, values);
	    final ListView listview = (ListView) findViewById(R.id.listView1);
	    listview.setAdapter(adapter);
	    
	    // handle list input
	    listview.setOnItemClickListener(new OnItemClickListener() {
	    	  @Override
	    	  public void onItemClick(AdapterView<?> parent, View view,
	    	    int position, long id) {
	    	    
	    		Intent intent = new Intent(MainActivity.this, CharacterActivity.class);
	    	    intent.putExtra(EXTRA_MESSAGE, (position));
	    	    startActivity(intent);
	    	  }
	    	}); 

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	

}
