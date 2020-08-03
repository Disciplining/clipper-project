package com.lyx.service;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyx.entity.Content;
import com.lyx.mapper.ContentMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service("contentServiceImpl")
public class ContentServiceImpl extends ServiceImpl<ContentMapper, Content> implements ContentService
{
	@Override
	public void addOneContent(Content content)
	{
		content.setOrderKey(this.getLastOrderKey()+1);
		this.save(content);
	}

	@Override
	public Boolean removeOneContent(int id)
	{
		return this.removeById(id);
	}

	@Override
	public void changeOrder(int id, boolean isUp)
	{
		if (isUp)
		{
			List<Content> contents = this.listAllContent();
			Content onUpUp = null; // 要上升的内容的上一条内容

			for (int i = 0; i <= contents.size()-1; i++)
			{
				if (contents.get(i).getContentId() == id)
				{
					if (i != 0)
					{
						onUpUp = contents.get(i-1);
						break;
					}
				}
			}

			if (Objects.nonNull(onUpUp))
				this.downOneContent(onUpUp.getContentId());
		}
		else
		{
			this.downOneContent(id);
		}
	}

	@Override
	public void setFirstOrLast(int id, boolean isFirst)
	{
		Content content = this.getById(id);
		if (isFirst)
			content.setOrderKey(this.getFirstOrderKey()-1);
		else
			content.setOrderKey(this.getLastOrderKey()+1);

		this.updateById(content);
	}

	@Override
	public List<Content> listAllContent()
	{
		List<Content> list = new LambdaQueryChainWrapper<>(this.baseMapper)
								.orderByAsc(Content::getOrderKey)
								.list();

		return list;
	}

	/**
	 * 获得第一名的排名
	 * @return
	 */
	private int getFirstOrderKey()
	{
		return this.listAllContent().get(0).getOrderKey();
	}

	/**
	 * 获得最后一名的排名
	 * @return
	 */
	private int getLastOrderKey()
	{
		List<Content> list = this.listAllContent();

		return list.get(list.size()-1).getOrderKey();
	}

	/**
	 * 将某条记录下降一个位（下降一个名次）
	 * @param id
	 * @return
	 */
	private void downOneContent(int id)
	{
		List<Content> list = this.listAllContent();// 所有的内容；


		Content toDown = null; // 要下降的内容 （在上边的内容）
		Content toUp = null; // 要上升的内容 (在下边的内容)

		for (Content foo : list)
		{
			if (Objects.nonNull(toDown))
			{
				toUp = foo;
				break;
			}
			if (foo.getContentId() == id)
				toDown = foo;
		}

		if (Objects.isNull(toUp)) // 要下降的是取后一个
			return;

		// 交换两个的值
		int originToDownOrderKey = toDown.getOrderKey();
		toDown.setOrderKey(toUp.getOrderKey());
		toUp.setOrderKey(originToDownOrderKey);

		this.updateBatchById(CollUtil.newArrayList(toDown, toUp));
	}
}