package com.codepath.search.imagesearch;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.codepath.search.utils.EndlessScrollListener;
import com.codepath.search.utils.Filters;
import com.codepath.search.utils.SearchResult;
import com.codepath.search.utils.SearchResultArrayAdapter;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

public class GridActivity extends Activity {
	public GridView gvImgSrch;
	public ArrayAdapter<String> gvAdapter;
	public int totalItems = 8;
	public int startPage = 0;
	private String query;
	ArrayList<SearchResult> srchResults = new ArrayList<SearchResult>();
	SearchResultArrayAdapter srchArrayAdapter;
	private String color;
	private String size;
	private String imgType;
	private String site;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grid);
		gvImgSrch = (GridView) findViewById(R.id.gvImageSearch);
		srchArrayAdapter = new SearchResultArrayAdapter(this, srchResults);
		gvImgSrch.setAdapter(srchArrayAdapter);
		srchResults.clear();
		gvImgSrch.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapter, View view, int position,
					long arg3) {
				Intent fullIt = new Intent(getApplicationContext(),FullImageDisplayActivity.class);
				SearchResult srcRes = srchResults.get(position);
				fullIt.putExtra("url", srcRes.getUrl());
				startActivity(fullIt);
			}
			
		});
		Intent intent = getIntent();
		query = intent.getStringExtra(Filters.QUERY);
		color = intent.getStringExtra(Filters.COLOR);
		size = intent.getStringExtra(Filters.SIZE);
		imgType = intent.getStringExtra(Filters.IMAGE_TYPE);
		site = intent.getStringExtra(Filters.SITE);
		int stpage = 0;
		searchResults(stpage);
		
		gvImgSrch.setOnScrollListener(new EndlessScrollListener() {
			@Override
			public void onLoadMore(int page, int totalItemsCount) {
				// TODO Auto-generated method stub
				  // Triggered only when new data needs to be appended to the list
                // Add whatever code is needed to append new items to your AdapterView
				searchResults(page);
			}

			
		});
		
	}
	

	public void searchResults(int page){
		AsyncHttpClient client = new AsyncHttpClient();
		String url = "https://ajax.googleapis.com/ajax/services/search/images?v=1.0&rsz=8&start=" + page + "&q=" + Uri.encode(query) + "&imgcolor=" + color.toLowerCase() + "&imgsz=" + size.toLowerCase() + "&imgtype=" + imgType.toLowerCase() + "&as_sitesearch=" + site.toLowerCase();
		System.out.println("URL :: " + url);
		client.get(url, new AsyncHttpResponseHandler() {
		        @Override
		        public void onSuccess(String response) {
		        		JSONArray srchJSONResults = null;
		        		try{
		        			JSONObject jsonResponse = new JSONObject(response);
		        			srchJSONResults = jsonResponse.getJSONObject("responseData").getJSONArray("results");
		        			srchResults.addAll(SearchResult.fromJSONArray(srchJSONResults));
		        			srchArrayAdapter.notifyDataSetChanged();
		        			
		        		}catch(JSONException ex){
		        			
		        		}
		        }
		    }
		
		
		);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.grid, menu);
		return true;
	}

}
