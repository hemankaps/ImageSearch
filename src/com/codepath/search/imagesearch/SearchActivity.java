package com.codepath.search.imagesearch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.codepath.search.utils.Color;
import com.codepath.search.utils.Filters;
import com.codepath.search.utils.ImageType;
import com.codepath.search.utils.Size;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

public class SearchActivity extends Activity {
    private static final int REQUEST_CODE=200;
    private String image_type=ImageType.FACES.toString();
    private String size=Size.SMALL.toString();
    private String color=Color.BLACK.toString();
    private String site = "google.com";
    private EditText etSrchQury;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search, menu);
		return true;
	}
	
	 public void onSettingsAction(MenuItem mi){
		Intent it = new Intent(this, SettingsActivity.class);
		it.putExtra(Filters.IMAGE_TYPE, image_type);
		it.putExtra(Filters.SIZE, size);
		it.putExtra(Filters.COLOR, color);
		it.putExtra(Filters.SITE,site);
		
		startActivityForResult(it, REQUEST_CODE);
	
	 }
	 
	 @Override
	 protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		 if(requestCode == REQUEST_CODE && resultCode == RESULT_OK){
			 image_type = data.getStringExtra(Filters.IMAGE_TYPE);
			 size = data.getStringExtra(Filters.SIZE);
			 color = data.getStringExtra(Filters.COLOR);
			 site = data.getStringExtra(Filters.SITE);
		 }
	 }
	 
	 public void search(View v){
		 etSrchQury = (EditText) findViewById(R.id.etSearch);
		 Intent itsrch = new Intent(this,GridActivity.class);
		 itsrch.putExtra(Filters.IMAGE_TYPE, image_type);
		 itsrch.putExtra(Filters.SIZE, size);
		 itsrch.putExtra(Filters.COLOR, color);
		 itsrch.putExtra(Filters.QUERY, etSrchQury.getEditableText().toString().trim());
		 itsrch.putExtra(Filters.SITE, site);
		 
		 startActivity(itsrch);
		 
	 }

	
}
