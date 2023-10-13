package org.zerock.myapp;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import java.util.Arrays;

@Log4j2

@ServletComponentScan
@SpringBootApplication
public class SpringmybatisApplication extends ServletInitializer{

	public static void main(String[] args) {
//		SpringApplication.run(SpringmybatisApplication.class, args);

		SpringApplication app = new SpringApplication(SpringmybatisApplication.class);
		app.setWebApplicationType(WebApplicationType.SERVLET);
//		app.setWebApplicationType(WebApplicationType.NONE);

		app.run(args);

		log.trace("main({}) invoked.", Arrays.toString(args));
	} // main

} // end class
