package com.cybage.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages="com.cybage")
@EnableJpaRepositories("com.cybage.dao")
@EntityScan("com.cybage.model")
public class SpringDataJpaBookManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaBookManagementSystemApplication.class, args);
	}

}
