package com.lyx.controller;

import com.lyx.entity.Content;
import com.lyx.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ContentController
{
    @Autowired
    @Qualifier("contentServiceImpl")
    private ContentService service;

    /**
     * 添加一条内容
     */
    @PostMapping("/addOneContent")
    @ResponseBody
    public void addOneContent(@RequestBody Content content)
    {
        service.addOneContent(content);
    }

    /**
     * 根据id更新一条内容
     */
    @PostMapping("/updateContextById")
    @ResponseBody
    public void updateContextById(@RequestBody Content content)
    {
        service.updateById(content);
    }

    /**
     * 查询所有内容
     * @return
     */
    @GetMapping("/listAllContent")
    @ResponseBody
    public List<Content> listAllContent()
    {
        return service.listAllContent();
    }

    /**
     * 删除一条内容
     */
    @ResponseBody
    @DeleteMapping("/removeOneContent")
    public void removeOneContent(@RequestParam("id") int id)
    {
        service.removeOneContent(id);
    }

    /**
     * 上下移
     */
    @PutMapping("/content/{id}")
    @ResponseBody
    public void changeOrder(@PathVariable("id") int id, @RequestParam boolean isUp)
    {
        service.changeOrder(id, isUp);
    }

    /**
     * 移到最前 移到最后
     */
    @PutMapping("/content/first-or-last/{id}")
    @ResponseBody
    public void setFirstOrLast(@PathVariable("id") int id, @RequestParam boolean isFirst)
    {
        service.setFirstOrLast(id, isFirst);
    }
}
