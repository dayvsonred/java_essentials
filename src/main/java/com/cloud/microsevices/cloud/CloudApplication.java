package com.cloud.microsevices.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;




@SpringBootApplication
public class CloudApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CloudApplication.class, args);
		
		System.out.println("start cloud project online ---------------------------- ");  
		
	}

}
