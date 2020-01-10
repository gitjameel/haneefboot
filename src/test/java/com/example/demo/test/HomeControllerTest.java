package com.example.demo.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.Book;
import com.example.demo.HomeRepository;
import com.example.demo.HomeService;

@RunWith(SpringJUnit4ClassRunner.class)  //or SpringRunner.class
@SpringBootTest
public class HomeControllerTest {

	@Autowired
	HomeService homeservice;
	
	@MockBean
	HomeRepository homerepository;
	
	@Test
	public void testForAllbooks() {
		
		ConcurrentHashMap<Integer, Book> books = new ConcurrentHashMap<>();
		books.put(1, new Book("Tamil"));
		books.put(2, new Book("English"));
		when(homerepository.getAllBooksfromDB()).thenReturn(books);
		assertTrue(homeservice.getAllBooksService().size() > 0);
	}
	
	@Test
	public void testForBookbyId() {
		when(homerepository.getBookfromDB(1)).thenReturn(new Book("Book on happiness"));
		assertNotNull(homeservice.getBookService(1));
	}
}
