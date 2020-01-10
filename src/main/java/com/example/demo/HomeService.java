package com.example.demo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService {
	
	@Autowired
	HomeRepository homerepository;

	public Map<Integer,Book> getAllBooksService() {
		Map<Integer,Book> bookslist = homerepository.getAllBooksfromDB();
		System.out.println("books map size :" + bookslist.size());
		return bookslist;
	}
	

	public Book getBookService(Integer id) {
		return homerepository.getBookfromDB(id);
	}
}
