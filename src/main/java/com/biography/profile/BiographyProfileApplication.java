package com.biography.profile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BiographyProfileApplication {

	public static void main(String[] args) {
		SpringApplication.run(BiographyProfileApplication.class, args);
	}

}
