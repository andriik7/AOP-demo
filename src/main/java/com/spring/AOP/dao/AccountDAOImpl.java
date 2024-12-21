package com.spring.AOP.dao;

import com.spring.AOP.model.Account;
import org.springframework.stereotype.Repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {

    Logger logger = LogManager.getLogger(AccountDAOImpl.class);

    @Override
    public List<Account> findAccounts() {

        Account account1 = new Account("John", "Silver");
        Account account2 = new Account("Mary", "Gold");
        Account account3 = new Account("Luis", "Platinum");

        logger.warn("Executing findAccounts() in " + this.getClass().getSimpleName());

        return new ArrayList<>(List.of(account1, account2, account3));
    }

    @Override
    public void saveAccount(Account account, boolean vipFlag) {
        logger.warn("Executing saveAccount() in " + this.getClass().getSimpleName());
    }

    @Override
    public void savePetro() {
        logger.warn("Executing savePetro() in " + this.getClass().getSimpleName());
    }

    @Override
    public void getAccount() {
        logger.warn("Executing getAccount() in " + this.getClass().getSimpleName());
    }

    @Override
    public void setAccount(Account account) {
        logger.warn("Executing setAccount() in " + this.getClass().getSimpleName());
    }
}
