package com.lyx.controller;

import com.lyx.entity.Content;
import com.lyx.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ContentController
{
	@Autowired
	@Qualifier("contentServiceImpl")
	private ContentService service;

	/**
	 * 查询所有内容
	 * @return
	 */
	@GetMapping("/listAllContent")
	@ResponseBody
	public List<Content> listAllContent()
	{
		return service.list();
	}

	/**
	 * 添加一条内容
	 * @param content
	 * @return
	 */
	@PostMapping("/addOneContent")
	public String addOneContent(Content content)
	{
		service.save(content);

		return "redirect:/";
	}

	/**
	 * 删除一条内容
	 * @param id
	 * @return
	 */
	@GetMapping("/removeOneContent")
	public String removeOneContent(@RequestParam("id") int id)
	{
		service.removeById(id);

		return "redirect:/";
	}
}