package org.example.exception;

import org.example.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)//捕获所有异常
    public Result exception(Exception exception){
        exception.printStackTrace();
        return Result.error("对不起，操作失败");
    }
}
