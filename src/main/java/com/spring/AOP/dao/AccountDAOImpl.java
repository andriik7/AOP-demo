package com.spring.AOP.dao;

import org.springframework.stereotype.Repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Repository
public class AccountDAOImpl implements AccountDAO {

    Logger logger = LogManager.getLogger(AccountDAOImpl.class);

    @Override
    public void saveAccount() {
        logger.warn("Executing saveAccount() in " + this.getClass().getSimpleName());
    }

    @Override
    public void savePetro() {
        logger.warn("Executing savePetro() in " + this.getClass().getSimpleName());
    }
}
