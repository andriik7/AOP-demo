package com.spring.AOP.dao;

import com.spring.AOP.model.Account;
import org.springframework.stereotype.Repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Repository
public class AccountDAOImpl implements AccountDAO {

    Logger logger = LogManager.getLogger(AccountDAOImpl.class);

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
