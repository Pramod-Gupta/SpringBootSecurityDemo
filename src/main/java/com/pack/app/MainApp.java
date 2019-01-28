package com.pack.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@ComponentScan({"com.pack.client","com.pack.controlle","com.pack.service","com.pack.config","com.pack.entity","com.pack.dao",})

@SpringBootApplication

public class MainApp {

	public static void main(String[] args) {
		
		
	SpringApplication.run(MainApp.class, args);
		
		/*BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode("m123"));
		SpringApplication.run(MainApp.class, args);*/
	}

}

