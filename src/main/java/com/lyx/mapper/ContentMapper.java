package com.lyx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyx.entity.Content;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("contentMapper")
public interface ContentMapper extends BaseMapper<Content>
{
}