package com.hope.mall.mallproduct.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hope.common.utils.PageUtils;
import com.hope.mall.mallproduct.entity.SkuInfoEntity;

import java.util.Map;

/**
 * sku信息
 *
 * @author chenyurong
 * @email yr_chen001@163.com
 * @date 2020-09-04 17:48:53
 */
public interface SkuInfoService extends IService<SkuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

