package com.javaguru.timemanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class TimemanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimemanagerApplication.class, args);
	}

}
