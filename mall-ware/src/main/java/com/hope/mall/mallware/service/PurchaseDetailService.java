package com.hope.mall.mallware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hope.common.utils.PageUtils;
import com.hope.mall.mallware.entity.PurchaseDetailEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenyurong
 * @email yr_chen001@163.com
 * @date 2020-09-04 20:58:43
 */
public interface PurchaseDetailService extends IService<PurchaseDetailEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

