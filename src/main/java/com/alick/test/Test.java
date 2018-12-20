package com.alick.test;

public class Test {

	public static void main(String[] args) {
		//NewDemo demo = new NewDemo();
		//demo.getName();
		NewDemo demo = new NewDemo(2);
		demo.send();
		demo.receive();
	}

}
