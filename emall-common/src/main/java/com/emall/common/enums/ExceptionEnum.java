package com.emall.common.enums;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnum
{
    CATEGORY_NOT_FOUND(404, "商品分类没查到"),
    ;

    private int code;
    private String msg;
}
