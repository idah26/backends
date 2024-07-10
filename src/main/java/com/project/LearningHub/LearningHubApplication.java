package com.project.LearningHub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@SpringBootApplication
@EnableFeignClients
public class LearningHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningHubApplication.class, args);
	}

}
