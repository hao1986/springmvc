package com.alick.mina.client;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

public class Test {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Person<String> person = new Person<String>();
		person.setClazz(String.class);
		person.setName("test");
		
		receive(person);
		
		
		Person<Info> pInfo = new Person<Info>();
		pInfo.setClazz(Info.class);
		pInfo.setName("info");
		Info info = send(pInfo);
		System.out.println("info = " + info.toString());
		
		Field[] fields = Info.class.getDeclaredFields();
		int size = fields.length;
		for(int i=0;i<size;i++){
			Field field = fields[i]; 
			field.setAccessible(true);
			System.out.println(field.get(info).toString());
			System.out.println("type = " + field.getType().toString());
			if("class java.lang.String".equals(field.getType().toString())){
			field.set(info, field.getType().cast("111"));
			}
			field.setAccessible(false);
		}
		System.out.println("info after = " + info.toString());
		
		
		Method[] methods = Info.class.getDeclaredMethods();
		int mSize = methods.length;
		for(int j=0; j<mSize; j++){
			Method method = methods[j];
			System.out.println("method = " + method.getName());
			if("getFather".equals(method.getName())){
				method.invoke(info);
			}
			if("setFather".equals(method.getName())){
				method.invoke(info, "father");
			}
		}
		System.out.println("info after2 = " + info.toString());
	}
	
	private static <T> T send(Person<T> person){
		Field[] fields = person.getClazz().getDeclaredFields();
		int size = fields.length;
		for(int i=0; i < size; i++){
			System.out.println(fields[i]);
		}
		
		Info info = new Info();
		info.setAge(19);
		info.setFather("father");
		info.setMoney(BigDecimal.ZERO);
		info.setMother("mother");
		
		return (T) info;
	}
	
	private static <T> void receive(Person<T> liu){
		
		System.out.println(liu.getName());
		System.out.println(liu.getClazz().getClass().getName());
		
	}

}
