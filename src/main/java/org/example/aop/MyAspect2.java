package org.example.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class MyAspect2 {

    //匹配DeptServiceImpl中的list()和delete(Integer id)方法
    //@Pointcut("execution(* org.example.service.DeptService.list()) || execution(* org.example.service.DeptService.list())")//常规写法

    @Pointcut("@annotation(org.example.aop.MyLog1)")//自定义注释写法
    private void pointcut(){}

    @Before("pointcut()")
    public void before(){
        log.info("MyAspect2...before...");
    }
    @Around("pointcut()")
    //JoinPoint抽象了连接点，可用其获取方法执行时的信息
    //Around用：ProceedingJoinPoint joinPoint，另外四种用：JoinPoint joinPoint
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("MyAspect2 around before...");

        //1. 获取 目标对象的类名
        String className = joinPoint.getTarget().getClass().getName();
        log.info("目标对象的类名:{}", className);

        //2. 获取 目标方法的方法名
        String methodName = joinPoint.getSignature().getName();
        log.info("目标方法的方法名: {}",methodName);

        //3. 获取 目标方法运行时传入的参数
        Object[] args = joinPoint.getArgs();
        log.info("目标方法运行时传入的参数: {}", Arrays.toString(args));

        //4. 放行 目标方法执行
        Object result = joinPoint.proceed();

        //5. 获取 目标方法运行的返回值
        log.info("目标方法运行的返回值: {}",result);

        log.info("MyAspect8 around after ...");
        return result;


    }
}
