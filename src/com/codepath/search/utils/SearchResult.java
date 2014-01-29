package com.codepath.search.utils;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SearchResult {
	public String url;
	public String thmbUrl;
	
	
	public SearchResult(JSONObject jobj){
		try{
			this.url = jobj.getString("url");
			this.thmbUrl = jobj.getString("tbUrl");
			
		} catch (JSONException je){
			this.url = null;
			this.thmbUrl = null;
		}
	}
	
	public String getUrl() {
		return url;
	}
	public String getThmbUrl() {
		return thmbUrl;
	}

	public static ArrayList<SearchResult> fromJSONArray(
			JSONArray array) {
		ArrayList<SearchResult> searchResult = new ArrayList<SearchResult>();
		for(int i=0; i <  array.length();i++){
			try{
				searchResult.add(new SearchResult(array.getJSONObject(i)));
			}catch(JSONException jex){
				
			}
		}
		return searchResult;
	}
	
	@Override
	public String toString(){
	 return this.url + this.thmbUrl;	
	}
	
}
