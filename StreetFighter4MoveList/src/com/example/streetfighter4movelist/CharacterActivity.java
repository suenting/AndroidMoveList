package com.example.streetfighter4movelist;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class CharacterActivity extends Activity {

	private int mMessage;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_character);
		
		Intent intent = getIntent();
		mMessage = intent.getIntExtra(MainActivity.EXTRA_MESSAGE, 0);
		// set action bar title
		setTitle(CharacterData.characterNames[mMessage]);
		getActionBar().setIcon(CharacterData.iconIds[mMessage]);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		final ImageView imgView = (ImageView)findViewById(R.id.moveData);
		imgView.setImageResource(CharacterData.moveIds[mMessage]);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.character, menu);
		return true;
	}
	
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home:
            NavUtils.navigateUpFromSameTask(this);
            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
	
	@Override
	public void onBackPressed(){
		super.onBackPressed();
		overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
	}
}
