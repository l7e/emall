package com.emall.item.service;

import com.eamll.item.pojo.Category;
import com.emall.common.enums.ExceptionEnum;
import com.emall.common.exception.EmallException;
import com.emall.item.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class CategoryService
{
    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> queryCategoryListByPid(Long pid)
    {
        Category t = new Category();
        t.setParentId(pid);
        //查询条件,mapper会把对象中的非空属性作为查询条件
        List<Category> list = categoryMapper.select(t);
        //判断结果
        if (CollectionUtils.isEmpty(list)) {
            throw new EmallException(ExceptionEnum.CATEGORY_NOT_FOUND);
        }
        return list;
    }
}
