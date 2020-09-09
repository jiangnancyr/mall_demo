package com.hope.mall.mallorder.dao;

import com.hope.mall.mallorder.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author chenyurong
 * @email yr_chen001@163.com
 * @date 2020-09-04 17:10:23
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
