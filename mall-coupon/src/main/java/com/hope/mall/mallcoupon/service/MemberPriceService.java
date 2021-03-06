package com.hope.mall.mallcoupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hope.common.utils.PageUtils;
import com.hope.mall.mallcoupon.entity.MemberPriceEntity;

import java.util.Map;

/**
 * 商品会员价格
 *
 * @author chenyurong
 * @email yr_chen001@163.com
 * @date 2020-09-04 18:35:19
 */
public interface MemberPriceService extends IService<MemberPriceEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

