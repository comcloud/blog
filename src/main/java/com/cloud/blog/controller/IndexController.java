package com.cloud.blog.controller;

import com.cloud.blog.entity.Article;
import com.cloud.blog.entity.Label;
import com.cloud.blog.serivce.IndexService;
import com.cloud.blog.util.ModelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2021/1/27 17:44
 */
@Controller
public class IndexController {

    @Autowired
    private IndexService indexService;

    @RequestMapping(value = {"/","/index"})
    public String index(Model model){
        List<Label> labelList = indexService.getAllFatherLabel();
        List<ModelUtil<Article,String>> articleList = indexService.getHomePageArticle();
        model.addAttribute("articleList",articleList);
        model.addAttribute("labelList",labelList);
        return "index";
    }

    @RequestMapping(value = {"/editor"})
    public String edit(){
        return "/editor";
    }
}
