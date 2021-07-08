package com.cloud.microsevices.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.log4j.Log4j2;
import utill.DateUtil;


@SpringBootApplication
public class CloudApplication {
	
	
	//@Autowired
	//private final DateUtil dateUtil;

	public static void main(String[] args) {
		SpringApplication.run(CloudApplication.class, args);
		
		System.out.println("start cloud project online ---------------------------- ");  
		
	}

}
