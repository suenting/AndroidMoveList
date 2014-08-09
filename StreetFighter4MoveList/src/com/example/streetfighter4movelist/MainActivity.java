package com.example.streetfighter4movelist;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.streetfighter4movelist.CharacterData;

public class MainActivity extends Activity {
	public static String EXTRA_MESSAGE = "com.movelist.MESSAGE";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// create and populate custom adapter
		CustomListAdapter customAdapter = new CustomListAdapter();
	    final ListView listview = (ListView) findViewById(R.id.listView1);
	    listview.setAdapter(customAdapter);
	    
	    // handle list input
	    listview.setOnItemClickListener(new OnItemClickListener() {
	    	  @Override
	    	  public void onItemClick(AdapterView<?> parent, View view,
	    	    int position, long id) {
	    	    
	    		Intent intent = new Intent(MainActivity.this, CharacterActivity.class);
	    	    intent.putExtra(EXTRA_MESSAGE, (position));
	    	    startActivity(intent);
	    	    overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
	    	  }
	    	}); 

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public class listViewObject
	{
		public String mName;
		public int mImagePath;
		public listViewObject(String name, int imagePath)
		{
			mName = name;
			mImagePath = imagePath;
		}
		public listViewObject(listViewObject obj)
		{
			this(obj.mName,obj.mImagePath);
		}
	}
	
	public class CustomListAdapter extends BaseAdapter
	{
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return CharacterData.characterNames.length;
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			listViewObject obj = new listViewObject(CharacterData.characterNames[arg0],CharacterData.iconIds[arg0]);
			return obj;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView==null)
            {
                LayoutInflater inflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.list_item, parent,false);
            }

            TextView charName = (TextView)convertView.findViewById(R.id.list_content);
            ImageView charIcon = (ImageView)convertView.findViewById(R.id.list_icon);

            charName.setText(CharacterData.characterNames[position]);
            charIcon.setImageResource(CharacterData.iconIds[position]);

            return convertView;
		}

	}
}
