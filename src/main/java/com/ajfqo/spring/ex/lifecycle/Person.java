package com.ajfqo.spring.ex.lifecycle;

public class Person {
	
	// 멤버변수 정의
	// 이름, 나이
	private String name;
	private int age;
	
	// 생성자를 통해 객체가 생성되면서 입력되게
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
	
}
