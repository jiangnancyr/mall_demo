package com.hope.mall.mallproduct.dao;

import com.hope.mall.mallproduct.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author chenyurong
 * @email yr_chen001@163.com
 * @date 2020-09-04 17:48:53
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
