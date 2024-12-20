package com.spring.AOP.dao;

import org.springframework.stereotype.Repository;

import java.util.logging.Logger;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Override
    public void saveAccount() {
        System.out.println(this.getClass().getSimpleName() + " processing account saving");
    }
}
