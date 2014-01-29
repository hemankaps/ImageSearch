package com.codepath.search.utils;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.codepath.search.imagesearch.R;
import com.loopj.android.image.SmartImageView;

public class SearchResultArrayAdapter extends ArrayAdapter<SearchResult> {

	public SearchResultArrayAdapter(Context context, List<SearchResult>  images){
		super(context, R.layout.image_results,images);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		SearchResult searchInfo = this.getItem(position);
		SmartImageView ivSmart;
		if(convertView == null){
			LayoutInflater inflater = LayoutInflater.from(getContext());
			ivSmart = (SmartImageView) inflater.inflate(R.layout.image_results,parent, false);
		} else {
			ivSmart = (SmartImageView) convertView;
			ivSmart.setImageResource(android.R.color.transparent);
		}
		
		ivSmart.setImageUrl(searchInfo.getThmbUrl());
		return ivSmart;
	}

}
