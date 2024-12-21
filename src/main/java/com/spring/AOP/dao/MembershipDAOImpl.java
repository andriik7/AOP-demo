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
}
