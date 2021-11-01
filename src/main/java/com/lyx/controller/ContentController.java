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

//    /**
//     * 添加一条内容
//     * @param content
//     * @return
//     */
//    @PostMapping("/addOneContent")
//    public String addOneContent(Content content)
//    {
//        service.addOneContent(content);
//
//        return "redirect:/";
//    }
//
//    /**
//     * 删除一条内容
//     * @param id
//     * @return
//     */
//    @GetMapping("/removeOneContent")
//    public String removeOneContent(@RequestParam("id") int id)
//    {
//        service.removeOneContent(id);
//
//        return "redirect:/";
//    }
//
//
//
//    @GetMapping("/content/{id}")
//    public String changeOrder(@PathVariable("id") int id, @RequestParam boolean isUp)
//    {
//        service.changeOrder(id, isUp);
//        return "redirect:/";
//    }
//
//    @GetMapping("/content/first-or-last/{id}")
//    public String setFirstOrLast(@PathVariable("id") int id, @RequestParam boolean isFirst)
//    {
//        service.setFirstOrLast(id, isFirst);
//        return "redirect:/";
//    }



























    /**
     * 根据id更新一条内容
     * @param content
     * @return
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
}
