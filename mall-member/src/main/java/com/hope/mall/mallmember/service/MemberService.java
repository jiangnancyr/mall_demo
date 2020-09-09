package com.hope.mall.mallmember.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hope.common.utils.PageUtils;
import com.hope.mall.mallmember.entity.MemberEntity;

import java.util.Map;

/**
 * 会员
 *
 * @author chenyurong
 * @email yr_chen001@163.com
 * @date 2020-09-04 18:43:54
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

