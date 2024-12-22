package com.spring.AOP.aspect;

import com.spring.AOP.model.Account;
import com.spring.AOP.model.Membership;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class DemoAnalyticsAspect {

    Logger logger = LogManager.getLogger(DemoAnalyticsAspect.class);

    @AfterThrowing(pointcut = "com.spring.AOP.aspect.expressions.AOPExpressions.forFindAccounts()",
            throwing = "theExc")
    public void afterThrowingFindAccounts(JoinPoint theJoinPoint, Throwable theExc) {

        logger.warn("====>>>> Executing @AfterThrowing on method: " + theJoinPoint.getSignature().toShortString());

        logger.warn("====>>>> The exception is: " + theExc);
    }


    @Before("com.spring.AOP.aspect.expressions.AOPExpressions.forDaoPackageNoGetterSetter()")
    public void performAnalysis(JoinPoint theJoinPoint) {

        logger.warn("====>>>> Performing analysis on setters");

        System.out.println("Arguments: ");

        Object[] args = theJoinPoint.getArgs();

        if (args.length == 0) {
            System.out.println("No arguments");
            return;
        }

        for (Object tempArg : args) {

            if (tempArg instanceof Account theAccount) {
                System.out.println("- Account name: " + theAccount.getName());
                System.out.println("- Account level: " + theAccount.getLevel());
            } else if (tempArg instanceof Membership membership) {
                System.out.println("- Membership name: " + membership.getName());
                System.out.println("- Membership code: " + membership.getCode());
            } else {
                System.out.println("- " + tempArg);
            }
        }
    }
}
