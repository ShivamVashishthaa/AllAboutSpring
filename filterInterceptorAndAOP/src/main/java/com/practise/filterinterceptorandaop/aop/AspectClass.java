package com.practise.filterinterceptorandaop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectClass {
    public static final Logger logger = LoggerFactory.getLogger(AspectClass.class);

    @Pointcut("execution(* com.practise.filterinterceptorandaop.service.*.*(..))")
    public void myPointcut() {
    }

    @Around("myPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("AOP intercept before service method");
        Object proceed = joinPoint.proceed();
        logger.info("AOP intercept after service method");
        return proceed;
    }


}
