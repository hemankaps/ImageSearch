package com.codepath.search.imagesearch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.codepath.search.utils.Color;
import com.codepath.search.utils.Filters;
import com.codepath.search.utils.ImageType;
import com.codepath.search.utils.Size;

public class SettingsActivity extends Activity {
	private Spinner spImageType;
	private Spinner spSize;
	private Spinner spColor;
	private EditText etSite;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		spImageType =(Spinner) findViewById(R.id.spImage);
		spSize = (Spinner) findViewById(R.id.spSize);
		spColor = (Spinner) findViewById(R.id.spColor);
		etSite = (EditText) findViewById(R.id.etSitePref);
		
		Intent it = getIntent();
		populateFilters(it);
	}

	private void populateFilters(Intent it) {
		spImageType.setSelection(ImageType.valueOf(it.getStringExtra(Filters.IMAGE_TYPE)).getValue());
		spColor.setSelection(Color.valueOf(it.getStringExtra(Filters.COLOR)).getValue());
		spSize.setSelection(Size.valueOf(it.getStringExtra(Filters.SIZE)).getValue());
		etSite.setText(it.getStringExtra(Filters.SITE));
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.settings, menu);
		return true;
	}

	public void saveSelectedFilter(View v){
		Intent data = new Intent();
		data.putExtra(Filters.IMAGE_TYPE, spImageType.getSelectedItem().toString());
		data.putExtra(Filters.SIZE,spSize.getSelectedItem().toString());
		data.putExtra(Filters.COLOR, spColor.getSelectedItem().toString());
		data.putExtra(Filters.SITE, etSite.getEditableText().toString().trim());
		
		setResult(RESULT_OK, data);
		finish();
		
	}
	

}
