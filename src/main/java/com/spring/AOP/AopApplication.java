package com.spring.AOP;

import com.spring.AOP.dao.AccountDAO;
import com.spring.AOP.dao.MembershipDAO;
import com.spring.AOP.model.Account;
import com.spring.AOP.model.Membership;
import com.spring.AOP.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO, TrafficFortuneService service) {
		return runner -> {

			//beforeAdviceDemo(accountDAO, membershipDAO);

			//afterReturningAdviceDemo(accountDAO);

			//afterThrowingAdviceDemo(accountDAO);
			
			aroundAdviceDemo(service);
		};
	}

	private void aroundAdviceDemo(TrafficFortuneService service) {

		String result = service.getFortune();
		System.out.println("The result is: " + result);
	}

	private void afterThrowingAdviceDemo(AccountDAO accountDAO) {
		try {
			List<Account> accounts = accountDAO.findAccounts(true);
		} catch (Exception e) {
			System.out.println("Exception was caused");
		}
	}

	private void afterReturningAdviceDemo(AccountDAO accountDAO) {

		List<Account> accounts = accountDAO.findAccounts();
	}

	private void beforeAdviceDemo(AccountDAO accountDAO, MembershipDAO membershipDAO) {

		accountDAO.saveAccount(new Account("test", "test"), true);

		accountDAO.getAccount();

		accountDAO.setAccount(new Account("test", "test"));

		accountDAO.savePetro();

		membershipDAO.saveMembership(new Membership("test", "12345"));

		membershipDAO.getMembership();

		membershipDAO.setMembership(new Membership("test", "test"));
	}

}
