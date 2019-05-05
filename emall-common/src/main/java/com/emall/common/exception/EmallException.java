package com.emall.common.exception;

import com.emall.common.enums.ExceptionEnum;

public class EmallException extends RuntimeException
{
    private ExceptionEnum exceptionEnum;

    public EmallException(ExceptionEnum exceptionEnum)
    {
        this.exceptionEnum = exceptionEnum;
    }

    public ExceptionEnum getExceptionEnum()
    {
        return exceptionEnum;
    }
}
