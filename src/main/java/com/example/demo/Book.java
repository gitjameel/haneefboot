package com.example.demo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="Book model")
public class Book {
	
	@ApiModelProperty(value="name of the book")
	private String name;
	
	public Book(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + "]";
	}
	
	
	  @Override public boolean equals(Object obj) {
	  
	  Book bkobj = (Book)obj; 
	  if(this==bkobj) 
		  return true;
	  if(this.getName().equals(bkobj.getName())) { 
		  return true; 
	  }else { 
		  return false; 
	  }
	  
	  }
	  
	  @Override public int hashCode() { return getName().hashCode(); }
	 
	
}
