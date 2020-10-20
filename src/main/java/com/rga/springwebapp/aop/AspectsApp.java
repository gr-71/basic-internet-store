package com.rga.springwebapp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AspectsApp {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.rga.springwebapp.controllers.*.*(..))")
    public void before(JoinPoint joinPoint){
        LOGGER.info("Calling {}", joinPoint);
    }

    @Around("@annotation(com.rga.springwebapp.aop.TrackTime)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long timeDuration = System.currentTimeMillis() - startTime;
        LOGGER.info("By {} was taken the following time {}", joinPoint, timeDuration);
        return result;
    }

}
