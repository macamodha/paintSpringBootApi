package com.chulan.paintSpringBootApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PaintApiApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(PaintApiApplication.class, args);
	}

}
