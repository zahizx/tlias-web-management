package org.example.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class MyAspect1 {

    @Pointcut("execution(* org.example.service.impl.DeptServiceImpl.*(..))")//抽取公共切入点表达式复用
    public void pointcut(){}

    @Before("pointcut()")
    public void before() {
        log.info("before...");
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("before...");

        //调用目标对象的原始方法执行
        Object result = proceedingJoinPoint.proceed();

        log.info("after...");
        return result;
    }

    @After("pointcut()")
    public void after() {
        log.info("after...");
    }

    @AfterReturning("pointcut()")
    public void afterReturning() {
        log.info("afterReturning...");
    }

    @AfterThrowing("pointcut()")
    public void afterThrowing() {
        log.info("afterThrowing...");
    }

}
