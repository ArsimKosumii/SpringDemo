package com.spring.springdemo;

public class Person {
	private long id;
	private String emri;
	private String mbiemri;
	private int age;
	
	public Person(long id, String emri, String mbiemri, int age ) {
		this.id = id;
		this.emri = emri;
		this.mbiemri = mbiemri;
		this.age = age;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmri() {
		return emri;
	}

	public void setEmri(String emri) {
		this.emri = emri;
	}

	public String getMbiemri() {
		return mbiemri;
	}

	public void setMbiemri(String mbiemri) {
		this.mbiemri = mbiemri;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean equals(Object o) {
		if(o instanceof Person) {
			return ((Person)o).getId() == id;
		}
		return false;
	}
}
