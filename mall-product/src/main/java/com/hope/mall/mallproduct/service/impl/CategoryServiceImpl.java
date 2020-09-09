package com.hope.mall.mallproduct.service.impl;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hope.common.utils.PageUtils;
import com.hope.common.utils.Query;

import com.hope.mall.mallproduct.dao.CategoryDao;
import com.hope.mall.mallproduct.entity.CategoryEntity;
import com.hope.mall.mallproduct.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        List<CategoryEntity> categoryEntities = baseMapper.selectList(null);
        List<CategoryEntity> collect = categoryEntities.stream()
                .filter((entity) -> entity.getParentCid() == 0)
                .map((menu)->{
                    menu.setChildren(getChildren(menu,categoryEntities));
                    return menu;
                })
                .sorted(Comparator.comparingInt(o -> (o.getSort() == null ? 0 : o.getSort())))
                .collect(Collectors.toList());

        return collect;
    }

    @Override
    public void removeMenusByIds(List<Long> longs) {

        baseMapper.deleteBatchIds(longs);
    }

    private List<CategoryEntity> getChildren(CategoryEntity categoryEntity,List<CategoryEntity> categoryEntities){
        List<CategoryEntity> collect = categoryEntities.stream()
                .filter((entity) -> entity.getParentCid() == categoryEntity.getCatId())
                .map((menu) -> {
                    menu.setChildren(getChildren(menu, categoryEntities));
                    return menu;
                })
                .sorted(Comparator.comparingInt(o -> (o.getSort() == null ? 0 : o.getSort())))
                .collect(Collectors.toList());
        return collect;
    }

}