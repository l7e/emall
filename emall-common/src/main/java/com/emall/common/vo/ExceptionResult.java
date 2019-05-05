package com.emall.common.vo;

import com.emall.common.enums.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class ExceptionResult
{
    private int code;
    private String message;
    private Long timestamp;

    public ExceptionResult(ExceptionEnum exceptionEnum)
    {
        code = exceptionEnum.getCode();
        message = exceptionEnum.getMsg();
        timestamp = System.currentTimeMillis();
    }
}
