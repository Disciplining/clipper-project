package com.lyx.controller;

import com.lyx.entity.Content;
import com.lyx.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 页面跳转
 */
@Controller
public class PageController
{
	@Autowired
	@Qualifier("contentServiceImpl")
	private ContentService service;

	/**
	 * 首页
	 * @return
	 */
	@GetMapping("/")
	public String index(Model model)
	{
		List<Content> list = service.list(); // 所有的内容

		model.addAttribute("all_content", list);

		return "index";
	}
}