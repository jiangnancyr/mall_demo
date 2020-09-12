package com.hope.mall.mallproduct.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.hope.common.valid.AddGroup;
import com.hope.common.valid.UpdateGroup;
import lombok.Data;
import org.apache.ibatis.annotations.Update;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;
import sun.plugin2.message.Message;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 品牌
 * 
 * @author chenyurong
 * @email yr_chen001@163.com
 * @date 2020-09-04 17:48:53
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 品牌id
	 */
	@TableId
	@NotNull(message = "新增商品不能指定id", groups = {AddGroup.class})
	@NotNull(message = "需改商品必须指定id", groups = {UpdateGroup.class})
	private Long brandId;
	/**
	 * 品牌名
	 */
	@NotEmpty
	@NotBlank(message = "输入不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String name;
	/**
	 * 品牌logo地址
	 */
	@NotEmpty
	@URL(message = "log必须是一个合法的url地址", groups = {AddGroup.class, UpdateGroup.class})
	private String logo;
	/**
	 * 介绍
	 */
	@NotEmpty
	private String descript;
	/**
	 * 显示状态[0-不显示；1-显示]
	 */
	@NotEmpty
	private Integer showStatus;
	/**
	 * 检索首字母
	 */
	@NotEmpty
	@Pattern(regexp = "/^[a-zA-Z]$/")
	private String firstLetter;
	/**
	 * 排序
	 */
	@Min(value = 0, message = "排序字段必须大于0")
	private Integer sort;

}
