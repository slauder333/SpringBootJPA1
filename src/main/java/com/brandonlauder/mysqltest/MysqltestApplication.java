package com.brandonlauder.mysqltest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableJpaRepositories(basePackages = "com.brandonlauder.mysqltest.repository")
@SpringBootApplication
public class MysqltestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MysqltestApplication.class, args);
	}

}
