package com.example.demo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

@Repository
public class HomeRepository {

	ConcurrentHashMap<Integer, Book> books = new ConcurrentHashMap<>();
	
	public Map<Integer,Book> getAllBooksfromDB() {
	
		books.put(1, new Book("Java"));
		books.put(2, new Book("c++"));
		books.put(3, new Book("nodejs"));
		
		return books;
	}
	
	public Book getBookfromDB(Integer id) {
		return books.get(id);
	}
}
