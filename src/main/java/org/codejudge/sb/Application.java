package org.codejudge.sb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.codejudge.sb"})
public class Application {
	private static Logger LOGGER = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		LOGGER.info("Application started...");
		SpringApplication.run(Application.class, args);
	}
}
