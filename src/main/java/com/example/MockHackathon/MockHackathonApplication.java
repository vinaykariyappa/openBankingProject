package com.example.MockHackathon;

import java.util.HashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableFeignClients
public class MockHackathonApplication {

	public static void main(String[] args) {
		SpringApplication.run(MockHackathonApplication.class, args);
	}
	
	@Bean
	public HashMap<String,String> getHashMap() {
		return new HashMap<String,String>();
	}
}
