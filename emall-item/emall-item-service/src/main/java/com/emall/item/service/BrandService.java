package com.emall.item.service;

import com.eamll.item.pojo.Brand;
import com.emall.common.enums.ExceptionEnum;
import com.emall.common.exception.EmallException;
import com.emall.common.vo.PageResult;
import com.emall.item.mapper.BrandMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class BrandService
{
    @Autowired
    private BrandMapper brandMapper;

    /**
     * 分页查询品牌
     *
     * @param page
     * @param rows
     * @param sortBy
     * @param descending
     * @param keyword
     * @return
     */
    public PageResult<Brand> queryBrandByList(Integer page, Integer rows, String sortBy, Boolean descending, String keyword)
    {
        //分页
        PageHelper.startPage(page, rows);
        //过滤
        Example example = new Example(Brand.class);
        if (StringUtils.isNotBlank(keyword)) {
            //过滤条件
            example.createCriteria().orLike("name", "%" + keyword + "%")
                    .orEqualTo("letter", keyword.toUpperCase());

        }
        //排序
        if (StringUtils.isNotBlank(sortBy)) {
            String orderByClaus = sortBy + (descending ? " DESC" : " ASC");     //注意留空格
            example.setOrderByClause(orderByClaus);
        }


        //查询
        List<Brand> brandList = brandMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(brandList)) {
            throw new EmallException(ExceptionEnum.BRAND_NOT_FOUND);
        }

        //解析分页结果
        PageInfo<Brand> info = new PageInfo<>(brandList);
        return new PageResult<>(info.getTotal(), brandList);
    }


    /**
     * 新增品牌
     *
     * @param brand
     * @param cids
     */
    @Transactional
    public void saveBrand(Brand brand, List<Long> cids)
    {
        brand.setId(null);
        int count = brandMapper.insert(brand);
        if (count == 0) {
            throw new EmallException(ExceptionEnum.BRAND_SAVE_ERROR);
        }

        //新增中间表
        for (Long cid : cids) {
            count = brandMapper.insertCategoryBrand(cid, brand.getId());
            if (count == 0) {
                throw new EmallException(ExceptionEnum.BRAND_SAVE_ERROR);
            }
        }
    }
}
