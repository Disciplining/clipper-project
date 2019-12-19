package com.lyx.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyx.entity.Content;
import com.lyx.mapper.ContentMapper;
import org.springframework.stereotype.Service;

@Service("contentServiceImpl")
public class ContentServiceImpl extends ServiceImpl<ContentMapper, Content> implements ContentService
{
}