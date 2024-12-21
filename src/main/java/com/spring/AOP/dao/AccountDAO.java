package com.spring.AOP.dao;

import com.spring.AOP.model.Account;

import java.util.List;

public interface AccountDAO {

    List<Account> findAccounts();

    void saveAccount(Account account, boolean vipFlag);

    void savePetro();

    void getAccount();

    void setAccount(Account account);
}
