package org.example.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 将此注解加到两个以上指定方法上，可简化切面表达式
 */
@Retention(RetentionPolicy.RUNTIME)//生效时间
@Target(ElementType.METHOD)//生效范围
public @interface MyLog1 {
}
