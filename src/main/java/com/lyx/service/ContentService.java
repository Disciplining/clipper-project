package com.lyx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyx.entity.Content;

import java.util.List;

public interface ContentService extends IService<Content>
{
	/**
	 * 增加一条内容
	 * @param content
	 * @return
	 */
	void addOneContent(Content content);

	/**
	 * 根据 id 删除一条内容
	 * @param id
	 * @return
	 */
	Boolean removeOneContent(int id);

	/**
	 * 修改排序
	 * @param id
	 * @param isUp ture-上升一个排名 false-下降一个排名
	 */
	void changeOrder(int id, boolean isUp);

	/**
	 * 移动到最前或最后
	 * @param id
	 * @param isFirst
	 */
	void setFirstOrLast(int id, boolean isFirst);

	/**
	 * 获取所有的内容，按排序权重排
	 * @return
	 */
	List<Content> listAllContent();
}