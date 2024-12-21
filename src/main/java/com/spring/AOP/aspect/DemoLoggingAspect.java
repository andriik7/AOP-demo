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
    @Pointcut("execution(* com.spring.AOP.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("execution(* com.spring.AOP.dao.*.get*(..))")
    private void forGetter() {}

    @Pointcut("execution(* com.spring.AOP.dao.*.set*(..))")
    private void forSetter() {}


    @Before("forDaoPackage() && !(forGetter() || forSetter())")
    public void beforeSaveAccountAdvice() {

        logger.warn("====>>>> Executing @Before advice on save*");
    }

    @Before("forDaoPackage() && forSetter()")
    public void performAnalysis() {

        logger.warn("====>>>> Performing analysis");

    }

    @After("forDaoPackage() && forGetter()")
    public void afterSaveAccountAdvice() {

        logger.warn("====>>>> Executing @After advice on save*");
    }
}
