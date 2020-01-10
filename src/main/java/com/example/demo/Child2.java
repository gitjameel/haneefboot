package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary   //denotes that this class bean will have high priority compared with child1 while autowiring
public class Child2 implements Parent {

	@Override
	public String parentcharacter() {
		return "Child 2 character";
	}

}
