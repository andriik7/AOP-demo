package com.spring.AOP.aspect;

import com.spring.AOP.model.Account;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(1)
public class DemoLoggingAspect {

    private static final Logger logger = LogManager.getLogger(DemoLoggingAspect.class);

    @AfterReturning(
            pointcut = "com.spring.AOP.aspect.expressions.AOPExpressions.forFindAccounts()",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, Object result) {

        System.out.println("=====>>> Executing afterReturningFindAccountsAdvice on method: " + theJoinPoint.getSignature().toShortString());

        System.out.println("=====>>> Result is: " + result);

        accountsNamesToUppercase(result);

        System.out.println("=====>>> Modified result is: " + result);
    }

    @Before("com.spring.AOP.aspect.expressions.AOPExpressions.forDaoPackageNoGetterSetter()")
    public void beforeSaveAccountAdvice(JoinPoint theJoinPoint) {

        logger.warn("====>>>> Executing @Before logging advice on no getters/setters");

        System.out.println("Method: " + theJoinPoint.getSignature());
    }

    private void accountsNamesToUppercase(Object result) {

        if (result instanceof List) {
            List<Account> accounts = (List<Account>) result;
            accounts.forEach(account -> account.setName(account.getName().toUpperCase()));
        }
    }
}
