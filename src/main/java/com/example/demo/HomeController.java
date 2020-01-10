package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("api")
public class HomeController {

	@Autowired
	//@Qualifier("child1")
	Parent parent;
	
	@Autowired
	HomeService homeservice;
	
	@RequestMapping(value="/")
	public String get() {
		return parent.parentcharacter();
	}
	@ApiOperation(value="Get book name by id",response=Book.class)
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Book getBook( @ApiParam(value="id required for fetching book details")  @PathVariable Integer id) {
		return homeservice.getBookService(id);
	}
	
	@ApiOperation(value="get all books present",response=List.class)
	@GetMapping(value="/allbooks")
	public List<Book> getAll() {
        System.out.println("Inside the getall service");
		return new ArrayList<Book>(homeservice.getAllBooksService().values());
	}
	
	
	@GetMapping(value="/containercall")
	public String dockerContainercall1() {
        System.out.println("Inside the dockerContainercall1 service");
		ResponseEntity<String> responseEntity = new RestTemplate().getForEntity("http://bootcontainer2:8200/getcontainerresponse", String.class);
		return responseEntity.getBody();
	}
	
	@GetMapping(value="/getcontainerresponse")
	public String getcontainerresponse() {
        System.out.println("Inside the dockerContainercall2 service");
		return "Success.Connected to container 2";
	}
}
