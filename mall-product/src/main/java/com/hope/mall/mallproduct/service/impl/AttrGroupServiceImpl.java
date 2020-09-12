package com.hope.mall.mallproduct.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.boot.autoconfigure.quartz.QuartzAutoConfiguration;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hope.common.utils.PageUtils;
import com.hope.common.utils.Query;

import com.hope.mall.mallproduct.dao.AttrGroupDao;
import com.hope.mall.mallproduct.entity.AttrGroupEntity;
import com.hope.mall.mallproduct.service.AttrGroupService;

import javax.swing.plaf.basic.BasicSplitPaneUI;


@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupDao, AttrGroupEntity> implements AttrGroupService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                new QueryWrapper<AttrGroupEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, long catelogId) {

        String key = (String) params.get("key");
        //新的查询规则
        QueryWrapper<AttrGroupEntity> wrapper = new QueryWrapper<AttrGroupEntity>().eq("catelog_id", catelogId);
        if (!StringUtils.isEmpty(key)){
            wrapper.and((Object)-> Object.eq("attr_group_id", key)
                    .or().like("attr_group_name", key));

        }
        if (catelogId == 0){
            IPage<AttrGroupEntity> page = this.page(new Query<AttrGroupEntity>().getPage(params),
                                                    new QueryWrapper<AttrGroupEntity>());
            // 返回pageUtils，用于解析页面
            return new PageUtils(page);
        }else{
            wrapper.eq("catelog_id", catelogId);
            IPage<AttrGroupEntity> page = this.page(new Query<AttrGroupEntity>().getPage(params),
                    wrapper);
            return new PageUtils(page);
        }

    }

}