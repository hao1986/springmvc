package com.alick.mina.client;

import java.math.BigDecimal;

public class Info {
	private String father;
	
	private String mother;
	
	private Integer age;
	
	private BigDecimal money;

	public String getFather() {
		return father;
	}

	public void setFather(String father) {
		this.father = father;
	}

	public String getMother() {
		return mother;
	}

	public void setMother(String mother) {
		this.mother = mother;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "Info [father=" + father + ", mother=" + mother + ", age=" + age + ", money=" + money + "]";
	}
	
	
	
	
}
