package com.example.agroltec;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableAutoConfiguration
@EnableConfigurationProperties
@SpringBootApplication
public class AgroltecApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AgroltecApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}

	
}
