package com.pack.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication

public class MainApp {

	public static void main(String[] args) {

		// SpringApplication.run(MainApp.class, args);

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println("Encoding>>>" + encoder.encode("m123"));
		SpringApplication.run(MainApp.class, args);
	}

}
