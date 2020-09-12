package com.hope.mall.mallproduct.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.hope.common.valid.AddGroup;
import com.hope.common.valid.UpdateGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hope.mall.mallproduct.entity.BrandEntity;
import com.hope.mall.mallproduct.service.BrandService;
import com.hope.common.utils.PageUtils;
import com.hope.common.utils.R;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.validation.Valid;


/**
 * 品牌
 *
 * @author chenyurong
 * @email yr_chen001@163.com
 * @date 2020-09-04 17:48:53
 */
@RestController
@RequestMapping("mallproduct/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("mallproduct:brand:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = brandService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{brandId}")
    //@RequiresPermissions("mallproduct:brand:info")
    public R info(@PathVariable("brandId") Long brandId){
		BrandEntity brand = brandService.getById(brandId);

        return R.ok().put("brand", brand);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("mallproduct:brand:save")
    public R save(@Validated(AddGroup.class) @RequestBody BrandEntity brand, BindingResult result){
		brandService.save(brand);
        HashMap<String, String > map = new HashMap<>();
        result.getFieldErrors().forEach((item)-> {
            String message = item.getDefaultMessage();
            String field = item.getField();
            map.put(field, message);
        });
        return R.ok().put("data", map);
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("mallproduct:brand:update")
    public R update(@Validated(UpdateGroup.class) @RequestBody BrandEntity brand){
		brandService.updateDetail(brand);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("mallproduct:brand:delete")
    public R delete(@RequestBody Long[] brandIds){
		brandService.removeByIds(Arrays.asList(brandIds));

        return R.ok();
    }

}
