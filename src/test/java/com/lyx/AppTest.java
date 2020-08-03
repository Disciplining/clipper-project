package com.lyx;

import com.lyx.service.ContentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AppTest
{
    @Autowired
    @Qualifier("contentServiceImpl")
    private ContentService service;

    @Test
    public void test1()
    {
        service.setFirstOrLast(6, false);
    }
}