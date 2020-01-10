package com.example.demo;

import org.springframework.stereotype.Component;

@Component("child1")
public class Child1 implements Parent{

	@Override
	public String parentcharacter() {
		return "Child 1 character";
	}

}
