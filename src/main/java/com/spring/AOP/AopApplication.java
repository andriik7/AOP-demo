package com.spring.AOP;

import com.spring.AOP.dao.AccountDAO;
import com.spring.AOP.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		return runner -> {
			beforeAdviceDemo(accountDAO, membershipDAO);
		};
	}

	public void beforeAdviceDemo(AccountDAO accountDAO, MembershipDAO membershipDAO) {

		accountDAO.saveAccount();

		membershipDAO.saveAccount();
	}

}
