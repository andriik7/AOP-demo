package com.spring.AOP.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Aspect
@Component
public class DemoLoggingAspect {

    private static final Logger logger = LogManager.getLogger(DemoLoggingAspect.class);

    @Before("execution(* com.spring.AOP.dao.MembershipDAO.saveAccount())")
    public void beforeSaveAccountAdvice() {

        logger.warn("Executing @Before advice on saveAccount()");
    }

    @After("execution(* saveAccount())")
    public void afterSaveAccountAdvice() {

        logger.warn("Executing @After advice on saveAccount()");
    }
}
