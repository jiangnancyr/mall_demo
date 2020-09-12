package com.hope.mall.mallproduct.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import com.hope.common.valid.AddGroup;
import com.hope.common.valid.UpdateGroup;
import com.hope.mall.mallproduct.dao.BrandDao;
import com.hope.mall.mallproduct.dao.CategoryDao;
import com.hope.mall.mallproduct.entity.BrandEntity;
import com.hope.mall.mallproduct.entity.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hope.common.utils.PageUtils;
import com.hope.common.utils.Query;

import com.hope.mall.mallproduct.dao.CategoryBrandRelationDao;
import com.hope.mall.mallproduct.entity.CategoryBrandRelationEntity;
import com.hope.mall.mallproduct.service.CategoryBrandRelationService;

import javax.validation.constraints.NotNull;


@Service("categoryBrandRelationService")
public class CategoryBrandRelationServiceImpl extends ServiceImpl<CategoryBrandRelationDao, CategoryBrandRelationEntity> implements CategoryBrandRelationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryBrandRelationEntity> page = this.page(
                new Query<CategoryBrandRelationEntity>().getPage(params),
                new QueryWrapper<CategoryBrandRelationEntity>()
        );

        return new PageUtils(page);
    }

    @Autowired(required = false)
    private BrandDao brandDao;

    @Autowired(required = false)
    private CategoryDao categoryDao;

    @Override
    public void saveDetail(CategoryBrandRelationEntity categoryBrandRelation) {
        Long brandId = categoryBrandRelation.getBrandId();
        Long catelogId = categoryBrandRelation.getCatelogId();

        BrandEntity brandEntity = brandDao.selectById(brandId);
        CategoryEntity categoryEntity = categoryDao.selectById(catelogId);

        categoryBrandRelation.setBrandName(brandEntity.getName());
        categoryBrandRelation.setCatelogName(categoryEntity.getName());
        //查询详细名

        this.save(categoryBrandRelation);
    }

    @Override
    public void updateBrand(@NotNull(message = "新增商品不能指定id", groups = {AddGroup.class}) @NotNull(message = "需改商品必须指定id", groups = {UpdateGroup.class}) Long brandId, String name) {
        CategoryBrandRelationEntity categoryBrandRelationEntity = new CategoryBrandRelationEntity();
        categoryBrandRelationEntity.setBrandName(name);
        categoryBrandRelationEntity.setBrandId(brandId);
        this.update(categoryBrandRelationEntity,
                new UpdateWrapper<CategoryBrandRelationEntity>().eq("brand_id", brandId));
    }

    @Override
    public void updateCategory(Long catId, String name) {
        CategoryBrandRelationEntity categoryBrandRelationEntity = new CategoryBrandRelationEntity();
        categoryBrandRelationEntity.setCatelogId(catId);
        categoryBrandRelationEntity.setCatelogName(name);
        this.update(categoryBrandRelationEntity,
                new UpdateWrapper<CategoryBrandRelationEntity>().eq("catelog_id",catId));
    }

}