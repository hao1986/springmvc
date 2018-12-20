package com.alick.test;

public abstract class Demo {
	
	private static final String KEY="dts.alik";
	
	public Demo(){
		System.out.println("Demo constructor");
	}
	
	public Demo(int i){
		System.out.println("i = " + i);
	}
	
	static{
		System.out.println("Demo static ");
	}
	
	protected String getName(){
		System.out.println("KEY = " + getKey());
		return KEY; 
	}
	
	private String getKey(){
		System.out.println("getKey = " + KEY);
		return "getKey";
	}

}
