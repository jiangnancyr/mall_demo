package com.hope.mall.mallproduct.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hope.common.utils.PageUtils;
import com.hope.common.valid.AddGroup;
import com.hope.common.valid.UpdateGroup;
import com.hope.mall.mallproduct.entity.CategoryBrandRelationEntity;

import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * 品牌分类关联
 *
 * @author chenyurong
 * @email yr_chen001@163.com
 * @date 2020-09-04 17:48:53
 */
public interface CategoryBrandRelationService extends IService<CategoryBrandRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveDetail(CategoryBrandRelationEntity categoryBrandRelation);

    void updateBrand(@NotNull(message = "新增商品不能指定id", groups = {AddGroup.class}) @NotNull(message = "需改商品必须指定id", groups = {UpdateGroup.class}) Long brandId, String name);

    void updateCategory(Long catId, String name);
}

