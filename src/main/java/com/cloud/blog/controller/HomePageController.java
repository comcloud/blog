package com.cloud.blog.controller;

import com.cloud.blog.entity.Article;
import com.cloud.blog.serivce.HomePageService;
import com.cloud.blog.serivce.IndexService;
import com.cloud.blog.util.ModelUtil;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2021/1/29 12:06
 */
@Controller
public class HomePageController {

    private Logger log = LoggerFactory.getLogger(HomePageController.class);

    @Autowired
    private HomePageService homePageService;

    @Autowired
    private IndexService indexService;

    @GetMapping("/getLabelById")
    public String getLabelById(@RequestParam("lid") String lid, Model model) {
        List<ModelUtil<Article,String>> articleList = indexService.getHomePageArticleById(lid);
        model.addAttribute("articleList", articleList);
        return "index::div_fragment";
    }

    @ResponseBody
    @RequestMapping(value = "/goToContentPage",method = RequestMethod.POST)
    public String goToContentPage(@RequestParam("aid") Integer aid,
                                  Model model, HttpSession session){
        Article article = homePageService.getArticleById(aid);
        model.addAttribute("articleContent",article);
        session.setAttribute("articleContent",article);
        return JsonNodeFactory.instance.objectNode().put("success",true).toString();
//        return "article_content";
    }

    @RequestMapping(value = "/contentPage")
    public String contentPage(){
        return "article_content";
    }

}
