package com.lyx.controller;

import com.lyx.entity.Content;
import com.lyx.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContentController
{
	@Autowired
	@Qualifier("contentServiceImpl")
	private ContentService service;

	/**
	 * 查久所有内容
	 * @return
	 */
	@GetMapping("/listAllContent")
	public List<Content> listAllContent()
	{
		return service.list();
	}
}