package com.dcg.blog.server.controller;


import com.dcg.blog.server.service.Blogservice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.fjl.common.entity.QueryPageBean;
import pers.fjl.common.entity.Result;

import javax.annotation.Resource;

@RestController
@RequestMapping("server/home")
public class HomeController {

    @Resource
    Blogservice blogservice;


    @PostMapping("/findHomePage")
    public Result findHomePage(@RequestBody QueryPageBean queryPageBean){
        return Result.ok("获取分页数据成功", blogservice.findHomePage(queryPageBean));
    }
}
