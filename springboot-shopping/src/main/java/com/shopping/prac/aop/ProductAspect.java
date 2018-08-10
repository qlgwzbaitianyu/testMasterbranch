package com.shopping.prac.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Array;
import java.util.Collections;

@Aspect
@Configuration
public class ProductAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.shopping.prac.controller.*.*(..))")
    public void before(JoinPoint joinpoint){
        logger.info("check for get access to product ");
        logger.info("Allow execution for {}", joinpoint);
    }



}
