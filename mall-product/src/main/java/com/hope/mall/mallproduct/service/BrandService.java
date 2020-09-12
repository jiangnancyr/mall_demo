package com.hope.mall.mallproduct.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hope.common.utils.PageUtils;
import com.hope.mall.mallproduct.entity.BrandEntity;

import java.util.Map;

/**
 * 品牌
 *
 * @author chenyurong
 * @email yr_chen001@163.com
 * @date 2020-09-04 17:48:53
 */
public interface BrandService extends IService<BrandEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void updateDetail(BrandEntity brand);
}

