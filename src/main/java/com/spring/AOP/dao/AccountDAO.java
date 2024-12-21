package com.spring.AOP.dao;

import com.spring.AOP.model.Account;

public interface AccountDAO {

    void saveAccount(Account account, boolean vipFlag);

    void savePetro();

    void getAccount();

    void setAccount(Account account);
}
