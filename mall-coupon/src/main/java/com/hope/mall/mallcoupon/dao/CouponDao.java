package com.hope.mall.mallcoupon.dao;

import com.hope.mall.mallcoupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author chenyurong
 * @email yr_chen001@163.com
 * @date 2020-09-04 18:35:19
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
