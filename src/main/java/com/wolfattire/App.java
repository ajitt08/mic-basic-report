package com.wolfattire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.wolfattire.config.AppSecurityConfig;
import com.wolfattire.config.AppWebMvcConfig;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
