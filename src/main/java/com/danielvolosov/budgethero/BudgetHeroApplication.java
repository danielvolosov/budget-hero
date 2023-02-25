package com.danielvolosov.budgethero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class BudgetHeroApplication {

	public static void main(String[] args) {
		SpringApplication.run(BudgetHeroApplication.class, args);
	}

}
