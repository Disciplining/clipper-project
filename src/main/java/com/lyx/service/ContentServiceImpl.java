package com.lyx.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyx.entity.Content;
import com.lyx.mapper.ContentMapper;
import com.lyx.util.DateUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service("contentServiceImpl")
public class ContentServiceImpl extends ServiceImpl<ContentMapper, Content> implements ContentService
{
	@Override
	public Boolean removeOneContent(int id)
	{
		File logFile = new File(System.getProperty("user.dir") + "/clipper-project.txt"); // 日志文件

		// 写入日志内容
		String logText = "删除一条内容，删除的内容是：[" + this.getById(id).getContentMaster() + "]，删除的时间是：" + DateUtil.getFormattedDate() + " " + DateUtil.getFormattedTime(System.currentTimeMillis()) + "\n";
		try
		{
			FileUtils.writeStringToFile(logFile, logText, "UTF-8",true);
		}
		catch (IOException e)
		{
			System.out.println("发生IO异常");
		}

		System.out.println("------------------------------文件位置：" + logFile.getAbsolutePath());

		return this.removeById(id);
	}
}