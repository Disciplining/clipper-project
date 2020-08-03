package com.lyx.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_content")
public class Content
{
	@TableId(value = "content_id", type = IdType.AUTO)
	private Integer contentId;

	@TableField("content_master")
	private String contentMaster;

	@TableField("order_key")
	private Integer orderKey;
}