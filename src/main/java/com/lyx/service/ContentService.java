package com.lyx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyx.entity.Content;

public interface ContentService extends IService<Content>
{
	/**
	 * 根据 id 删除一条内容
	 * @param id
	 * @return
	 */
	Boolean removeOneContent(int id);
}