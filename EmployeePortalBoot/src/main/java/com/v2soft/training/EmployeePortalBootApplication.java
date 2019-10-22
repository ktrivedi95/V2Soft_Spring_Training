package com.v2soft.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ComponentScan(basePackages = "com.v2soft.training")
@ImportResource({"classpath*:applicationContext.xml"})
/*@ComponentScan({"com.v2soft.training","com.v2soft.training.config",
				"com.v2soft.training.controller","com.v2soft.training.dao",
				"com.v2soft.training.datamodel","com.v2soft.training.filter",
				"com.v2soft.training.model","com.v2soft.training.service"})*/
public class EmployeePortalBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeePortalBootApplication.class, args);
	}

}
