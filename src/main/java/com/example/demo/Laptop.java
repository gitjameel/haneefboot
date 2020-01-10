package com.example.demo;

import org.springframework.stereotype.Component;

@Component(value="mylaptop")
public class Laptop {

	private String name= "dell";
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}


	public void getdetails() {
		System.out.println(this.name);
	}

}
