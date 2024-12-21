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

    @Before("execution(* save*(com.spring.AOP.model.Account, ..))")
    public void beforeSaveAccountAdvice() {

        logger.warn("Executing @Before advice on save*");
    }

    // () - no arguments
    // (*) - one argument of any type
    // (..) - 0 or more arguments of any types
    @After("execution(* save*(com.spring.AOP.model.*, ..))")
    public void afterSaveAccountAdvice() {

        logger.warn("Executing @After advice on save*");
    }
}
