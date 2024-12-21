package com.spring.AOP.dao;

import com.spring.AOP.model.Membership;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {

    Logger logger = LogManager.getLogger(MembershipDAOImpl.class);

    @Override
    public int saveMembership(Membership membership) {
        logger.warn("Executing saveMembership() in " + this.getClass().getSimpleName());

        return 1;
    }

    @Override
    public void getMembership() {
        logger.warn("Executing getMembership() in " + this.getClass().getSimpleName());
    }

    @Override
    public void setMembership(Membership membership) {
        logger.warn("Executing setMembership() in " + this.getClass().getSimpleName());
    }
}
