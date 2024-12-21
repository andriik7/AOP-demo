package com.spring.AOP.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class DemoCloudLogAspect {

    Logger logger = LogManager.getLogger(DemoCloudLogAspect.class);

    @Before("com.spring.AOP.aspect.expressions.AOPExpressions.forDaoPackageNoGetterSetter()")
    public void logToCloud() {

        logger.warn("====>>>> Logging to cloud");
    }
}
