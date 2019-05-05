package com.emall.common.advice;

import com.emall.common.enums.ExceptionEnum;
import com.emall.common.exception.EmallException;
import com.emall.common.vo.ExceptionResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler
{
    @ExceptionHandler(EmallException.class)   //拦截的异常类型
    public ResponseEntity<ExceptionResult> handleException(EmallException e)
    {
        ExceptionEnum exceptionEnum = e.getExceptionEnum();
        return ResponseEntity.status(exceptionEnum.getCode()).body(new ExceptionResult(e.getExceptionEnum()));
    }
}
