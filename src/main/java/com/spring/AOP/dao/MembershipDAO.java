package com.spring.AOP.dao;

import com.spring.AOP.model.Membership;

public interface MembershipDAO {

    int saveMembership(Membership membership);

    void getMembership();

    void setMembership(Membership membership);
}
