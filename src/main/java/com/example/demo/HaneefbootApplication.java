package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class HaneefbootApplication {
	
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(HaneefbootApplication.class, args);
		Student student1 = context.getBean(Student.class);
		student1.getdetails();
		
	}
	
	
	@Bean
	Docket docketInfo() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/*"))
				.apis(RequestHandlerSelectors.basePackage("com.example.demo"))
				.build()
				.apiInfo(getapiinfo());
	}
	
	
	ApiInfo getapiinfo() {
		return new ApiInfo("Books API", "API for getting book name based on id", "1.0.0", "Free to use" , null, null, null);
	}
	

}
