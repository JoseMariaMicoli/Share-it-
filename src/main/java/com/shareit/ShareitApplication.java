package com.shareit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackageClasses=com.shareit.Entity.User.class)
@SpringBootApplication
public class ShareitApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShareitApplication.class, args);
	}
}
