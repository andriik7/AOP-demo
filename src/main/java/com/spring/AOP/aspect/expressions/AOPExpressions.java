package com.spring.AOP.aspect.expressions;

import com.spring.AOP.aspect.DemoLoggingAspect;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.Pointcut;

public class AOPExpressions {

    // () - no arguments
    // (*) - one argument of any type
    // (..) - 0 or more arguments of any types
    @Pointcut("execution(* com.spring.AOP.dao.*.*(..))")
    public void forDaoPackage() {}

    @Pointcut("execution(* com.spring.AOP.dao.*.get*(..))")
    public void forGetter() {}

    @Pointcut("execution(* com.spring.AOP.dao.*.set*(..))")
    public void forSetter() {}

    @Pointcut("forDaoPackage() && !(forGetter() || forSetter())")
    public void forDaoPackageNoGetterSetter() {}
}
