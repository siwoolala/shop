package com.shop.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@Import(MyBatisConfig.class)
@ComponentScan(basePackages = {"com.shop.shop.service"})
@ComponentScan(basePackages = "com.shop.shop.repository")
@ComponentScan(basePackages = "com.shop.shop.config")
@SpringBootApplication(scanBasePackages = {"com.shop.shop.controller"})
public class ShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}
}
