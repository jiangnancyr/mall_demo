package com.hope.mall.mallorder.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hope.common.utils.PageUtils;
import com.hope.mall.mallorder.entity.OrderItemEntity;

import java.util.Map;

/**
 * 订单项信息
 *
 * @author chenyurong
 * @email yr_chen001@163.com
 * @date 2020-09-04 17:10:23
 */
public interface OrderItemService extends IService<OrderItemEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

