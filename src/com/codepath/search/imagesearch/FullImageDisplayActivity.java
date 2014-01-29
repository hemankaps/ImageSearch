package com.codepath.search.imagesearch;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.loopj.android.image.SmartImageView;

public class FullImageDisplayActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_full_image_display);
		String url = getIntent().getStringExtra("url");
		SmartImageView ivFullImg = (SmartImageView) findViewById(R.id.ivfullImage);
		ivFullImg.setImageUrl(url);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.full_image_display, menu);
		return true;
	}

}
