package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Student {
	
	private String name= "haneef";
	
	@Autowired
	@Qualifier("mylaptop")
	private Laptop laptop;

	public Student() {
		super();
		System.out.println("object created");
		
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}


	public void getdetails() {
		System.out.println(this.name + " has " + this.laptop.getName() + " laptop");
	}

}
