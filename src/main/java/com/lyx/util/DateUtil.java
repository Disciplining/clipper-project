package com.lyx.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 */
public class DateUtil
{
	/**
	 * 输入时间戳 输出格式化的时间(不包括日期)
	 * @param timeStamp
	 * @return
	 */
	public static String getFormattedTime(long timeStamp)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");

		return formatter.format(new Date(timeStamp));
	}

	/**
	 * 获得当前日期（不包括时间）
	 * @return
	 */
	public static String getFormattedDate()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		return formatter.format(new Date());
	}
}