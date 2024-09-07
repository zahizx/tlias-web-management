package org.example.aop;

import com.alibaba.fastjson2.JSONObject;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.utils.JwtUtils;
import org.example.pojo.OperateLog;
import org.example.mapper.OperateLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Component
@Aspect//切面类
@Slf4j
public class LogAspect {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Around("@annotation(org.example.anno.Log)")
    public Object recordLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        //操作人的Id
        //获取令牌并解析得到
        String jwt = request.getHeader("token");
        Claims claims= JwtUtils.parseJWT(jwt);
        Integer operateUser = (Integer) claims.get("id");

        //操作时间
        LocalDateTime operateTime =LocalDateTime.now();

        //操作类名
        String className = proceedingJoinPoint.getTarget().getClass().getName();

        //操作方法名
        String methodName = proceedingJoinPoint.getSignature().getName();

        //操作方法参数
        Object[] args = proceedingJoinPoint.getArgs();
        String methodParams = Arrays.toString(args);


        long begin = System.currentTimeMillis();

        //调用原始方法运行
        Object result = proceedingJoinPoint.proceed();


        long end = System.currentTimeMillis();

        //方法返回值
        String returnValue = JSONObject.toJSONString(result);

        //操作耗时
        Long costTime =end-begin;

        //记录操作日志
        operateLogMapper.insert(new OperateLog(null,operateUser,operateTime,className,methodName,methodParams,returnValue,costTime));
        log.info("AOP记录操作日志：{}",new OperateLog(null,operateUser,operateTime,className,methodName,methodParams,returnValue,costTime));
        return result;
    }
}
