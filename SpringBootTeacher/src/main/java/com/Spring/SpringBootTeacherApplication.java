package com.Spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.spring.repository")
public class SpringBootTeacherApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTeacherApplication.class, args);
	}

}
