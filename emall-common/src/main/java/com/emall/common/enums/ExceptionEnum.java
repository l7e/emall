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

    BRAND_NOT_FOUND(404, "品牌没查到"),

    BRAND_SAVE_ERROR(500, "新增品牌失败"),

    ;

    private int code;
    private String msg;
}
