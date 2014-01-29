package com.codepath.search.utils;

public enum Color {
	BLACK(0),
	BLUE(1),
	BROWN(2),
	GRAY(3),
	GREEN(4),
	RED(5);

	public int index=0;
	
	Color(int indx){
		this.index = indx;
		
	}
	
	public int getValue(){
		return index;
		
	}
}
