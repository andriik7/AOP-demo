package com.spring.AOP.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Aspect
@Component
public class DemoLoggingAspect {

    private static final Logger logger = LogManager.getLogger(DemoLoggingAspect.class);

    // () - no arguments
    // (*) - one argument of any type
    // (..) - 0 or more arguments of any types
    @Pointcut("execution(* com.spring.AOP.dao.*.*(com.spring.AOP.model.*, ..))")
    private void forDaoPackage() {}

    @Before("forDaoPackage()")
    public void beforeSaveAccountAdvice() {

        logger.warn("Executing @Before advice on save*");
    }

    @Before("forDaoPackage()")
    public void performAnalysis() {

        logger.warn("Performing analysis");

    }

    @After("forDaoPackage()")
    public void afterSaveAccountAdvice() {

        logger.warn("Executing @After advice on save*");
    }
}
