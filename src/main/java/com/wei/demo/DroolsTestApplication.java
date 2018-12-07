package com.wei.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;

@SpringBootApplication
public class DroolsTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DroolsTestApplication.class, args);
	}

}
