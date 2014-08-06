package com.example.androidmovelist;

import java.util.Locale;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class CharacterActivity extends FragmentActivity implements
		ActionBar.TabListener {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;
	
	int mMessage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_character);
		Intent intent = getIntent();
		mMessage = intent.getIntExtra(MainActivity.EXTRA_MESSAGE, 0);
		
		if(0==mMessage){setTitle("Ragna");}
		else if(1==mMessage){setTitle("Jin");}
		else if(2==mMessage){setTitle("Noel");}
		else if(3==mMessage){setTitle("Rachel");}
		else if(4==mMessage){setTitle("Taokaka");}
		else if(5==mMessage){setTitle("Tager");}
		else if(6==mMessage){setTitle("Litchi");}
		else if(7==mMessage){setTitle("Arakune");}
		else if(8==mMessage){setTitle("Bang");}
		else if(9==mMessage){setTitle("Carl");}
		else if(10==mMessage){setTitle("Hakumen");}
		else if(11==mMessage){setTitle("Tsubaki");}
		else if(12==mMessage){setTitle("Hazama");}
		else if(13==mMessage){setTitle("Makoto");}
		else if(14==mMessage){setTitle("Valkenhein");}
		else if(15==mMessage){setTitle("Platnium");}
		else if(16==mMessage){setTitle("Relius");}
		else if(17==mMessage){setTitle("Amane");}
		else if(18==mMessage){setTitle("Bullet");}
		else if(19==mMessage){setTitle("Azreal");}
		else if(20==mMessage){setTitle("Nu-13");}
		else if(21==mMessage){setTitle("Mu-12");}
		else if(22==mMessage){setTitle("Izayoi");}
		else if(23==mMessage){setTitle("Kagura");}
		else if(24==mMessage){setTitle("Terumi");}
		else if(25==mMessage){setTitle("Kokonoe");}

		// Set up the action bar.
		final ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

		// When swiping between different sections, select the corresponding
		// tab. We can also use ActionBar.Tab#select() to do this if we have
		// a reference to the Tab.
		mViewPager
				.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
					@Override
					public void onPageSelected(int position) {
						actionBar.setSelectedNavigationItem(position);
					}
				});

		// For each of the sections in the app, add a tab to the action bar.
		for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
			// Create a tab with text corresponding to the page title defined by
			// the adapter. Also specify this Activity object, which implements
			// the TabListener interface, as the callback (listener) for when
			// this tab is selected.
			actionBar.addTab(actionBar.newTab()
					.setText(mSectionsPagerAdapter.getPageTitle(i))
					.setTabListener(this));
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.ragna, menu);
		return true;
	}

	@Override
	public void onTabSelected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
		// When the given tab is selected, switch to the corresponding page in
		// the ViewPager.
		mViewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	@Override
	public void onTabReselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a DummySectionFragment (defined as a static inner class
			// below) with the page number as its lone argument.
			
			Fragment moveList = new CharacterFragment();
			Bundle args = new Bundle();
			args.putInt(CharacterFragment.ARG_SECTION_NUMBER, position);
			args.putInt(CharacterFragment.ARG_CHARACTER_NUMBER, mMessage);
			moveList.setArguments(args);
			return moveList;
		}

		@Override
		public int getCount() {
			// Show 3 total pages.
			return 2;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return getString(R.string.title_section1).toUpperCase(l);
			case 1:
				return getString(R.string.title_section2).toUpperCase(l);
			case 2:
				return getString(R.string.title_section3).toUpperCase(l);
			}
			return null;
		}
	}
	
	public static class CharacterFragment extends Fragment {
		public static final String ARG_CHARACTER_NUMBER = "character_number";
		public static final String ARG_SECTION_NUMBER = "section_number";
		public CharacterFragment(){
		}
		
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_move_list,container, false);
			ImageView imgView = (ImageView)rootView;
			switch(getArguments().getInt(ARG_CHARACTER_NUMBER))
			{
			case 0:
				if(0==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.ragna_styleish);}
				if(1==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.ragna_technical);}
				break;
			case 1:
				if(0==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.jin_styleish);}
				if(1==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.jin_technical);}
				break;
			case 2:
				if(0==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.noel_stylish);}
				if(1==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.noel_technical);}
				break;
			case 3:
				if(0==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.rachel_stylish);}
				if(1==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.rachel_technical);}
				break;
			case 4:
				if(0==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.taokaka_stylish);}
				if(1==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.taokaka_technical);}
				break;
			case 5:
				if(0==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.tager_stylish);}
				if(1==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.tager_technical);}
				break;
			case 6:
				if(0==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.litchi_stylish);}
				if(1==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.litchi_technical);}
				break;
			case 7:
				if(0==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.arakune_stylish);}
				if(1==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.arakune_technical);}
				break;
			case 8:
				if(0==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.bang_stylish);}
				if(1==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.bang_technical);}
				break;
			case 9:
				if(0==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.carl_stylish);}
				if(1==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.carl_technical);}
				break;
			case 10:
				if(0==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.hakumen_stylish);}
				if(1==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.hakumen_technical);}
				break;
			case 11:
				if(0==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.tsubaki_stylish);}
				if(1==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.tsubaki_technical);}
				break;
			case 12:
				if(0==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.hazama_stylish);}
				if(1==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.hazama_technical);}
				break;
			case 13:
				if(0==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.makoto_stylish);}
				if(1==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.makoto_technical);}
				break;
			case 14:
				if(0==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.valkenhayn_stylish);}
				if(1==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.valkenhayn_technical);}
				break;
			case 15:
				if(0==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.platinum_stylish);}
				if(1==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.platinum_technical);}
				break;
			case 16:
				if(0==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.relius_stylish);}
				if(1==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.relius_technical);}
				break;
			case 17:
				if(0==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.amane_stylish);}
				if(1==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.amane_technical);}
				break;
			case 18:
				if(0==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.bullet_stylish);}
				if(1==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.bullet_technical);}
				break;
			case 19:
				if(0==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.azrael_stylish);}
				if(1==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.azrael_technical);}
				break;
			case 20:
				if(0==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.nu13_stylish);}
				if(1==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.nu13_technical);}
				break;
			case 21:
				if(0==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.mu12_stylish);}
				if(1==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.mu12_technical);}
				break;
			case 22:
				if(0==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.izayoi_stylish);}
				if(1==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.izayoi_technical);}
				break;
			case 23:
				if(0==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.kagura_stylish);}
				if(1==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.kagura_technical);}
				break;
			case 24:
				if(0==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.terumi_stylish);}
				if(1==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.terumi_technical);}
				break;
			case 25:
				if(0==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.kokonoe_stylish);}
				if(1==getArguments().getInt(ARG_SECTION_NUMBER)){imgView.setImageResource(R.drawable.kokonoe_technical);}
				break;
			}

			
			return rootView;
		}		
	
	}
}
