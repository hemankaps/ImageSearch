package com.codepath.search.utils;

public enum ImageType {
	FACES(0),
	PHOTO(1),
	CLIPART(2),
	LINEART(3);
	
	private int index = 0;
	 ImageType(int val){
		this.index = val;
	}
	public int getValue(){
		return index;
	}
}
