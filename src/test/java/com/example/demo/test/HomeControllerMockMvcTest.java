package com.example.demo.test;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.HomeController;
import com.example.demo.HomeService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class HomeControllerMockMvcTest {
	
	private MockMvc mockmvc;
	  
	@Mock 
	private HomeService homeservice;
	 
	@InjectMocks   //homeservice mocked bean is injected
	HomeController homeController;
	
	@Autowired
	WebApplicationContext webapplicationContext;
	
	@Before
	public void setUp() {
		//mockmvc = MockMvcBuilders.standaloneSetup(homeController).build();  //for unit testing only the specific controller or service
		mockmvc = MockMvcBuilders.webAppContextSetup(webapplicationContext).build();  //kind of integration testing the complete flow from controller to service to dao
	}
	
	@Test
	public void testGetallbooksForStatusCode() throws Exception {
		mockmvc.perform(MockMvcRequestBuilders.get("/api/allbooks"))
				.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
	}
	
	@Test
	public void testGetAllBooksForListSize() throws Exception {
		mockmvc.perform(MockMvcRequestBuilders.get("/api/allbooks"))
				.andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(3)) );
	}
	
	@Test
	public void testGetBookById() throws Exception {
		mockmvc.perform(MockMvcRequestBuilders.get("/api/1"))
		       .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is("Java")) );
	}

}
