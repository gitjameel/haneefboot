package com.example.demo;

import java.util.LinkedHashSet;
import java.util.Set;

public class Test {
	
	public static void main(String args[]) {
		
		Set<String> set = new LinkedHashSet<String>();
		set.add("paaaa");
		set.add("maa");
		set.add("abccd");
		set.add("karr");
		set.add("maa");
		
		System.out.println(set);
		
		Set<Book> set1 = new LinkedHashSet<Book>();
		Book bk1 = new Book("java");
		Book bk2 = new Book("node");
		Book bk3 = new Book("phython");
	
		Book bk4 = new Book("java");
		
		set1.add(bk1);
		set1.add(bk2);
		set1.add(bk3);
		
		set1.remove(bk4);
		
		System.out.println(set1);
		
	//	Set<String> sortedset = new TreeSet<String>(set);
	//	System.out.println(sortedset);
		
	}

}
