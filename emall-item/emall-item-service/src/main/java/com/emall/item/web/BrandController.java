package com.emall.item.web;


import com.eamll.item.pojo.Brand;
import com.emall.common.vo.PageResult;
import com.emall.item.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("brand")
public class BrandController
{
    @Autowired
    private BrandService brandService;

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
    @GetMapping("list")
    public ResponseEntity<PageResult<Brand>> queryBrandByList(
            @RequestParam(value = "page", defaultValue = "1") Integer page,     //当前页
            @RequestParam(value = "rows", defaultValue = "5") Integer rows,     //每页条数
            @RequestParam(value = "sortBy", required = false) String sortBy,   //排序字段
            @RequestParam(value = "descending", defaultValue = "false") Boolean descending,     //是否降序
            @RequestParam(value = "keyword", required = false) String keyword          //搜索字
    )
    {
        return ResponseEntity.ok(brandService.queryBrandByList(page, rows, sortBy, descending, keyword));
    }


    /**
     * 新增品牌
     *
     * @param brand
     * @param cids
     * @return
     */
    @PostMapping
    public ResponseEntity<Void> saveBrand(Brand brand, @RequestParam("cids") List<Long> cids)
    {
        brandService.saveBrand(brand, cids);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
