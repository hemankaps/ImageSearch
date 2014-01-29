package com.codepath.search.utils;

public enum Size {
	SMALL(0),
	MEDIUM(1),
	LARGE(2),
	XLARGE(3);
	
	private int index = 0;
	
	Size(int val){
		this.index=val;
	
	}

	public int getValue(){
		return index;
	}
}
