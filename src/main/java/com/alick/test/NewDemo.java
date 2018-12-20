package com.alick.test;

public class NewDemo extends Demo implements IDemo {
	
	static{
		System.out.println("New Demo static");
	}
	
	private String member;
	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}
	
	public NewDemo() {
		System.out.println("new Demo");
	}
	
	public NewDemo(int i){
		super(i);
	}

	@Override
	public String receive() {
		System.out.println("receive method");
		return "receive";
	}

	@Override
	public Integer send() {
		System.out.println("send method");
		return 0;
	}
}
