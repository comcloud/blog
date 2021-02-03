package com.cloud.blog.controller;

import com.cloud.blog.entity.Article;
import com.cloud.blog.entity.Label;
import com.cloud.blog.serivce.ArticleService;
import com.cloud.blog.util.ModelUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2021/2/1 12:07
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @ResponseBody
    @PostMapping(value = "/saveArticle")
    public String saveArticle(@RequestBody String body) throws UnsupportedEncodingException {
        String markdownContent = URLDecoder.decode(body, "utf-8").trim();

        final ObjectNode objectNode = JsonNodeFactory.instance.objectNode();
        ModelUtil<Boolean, Boolean> saveArticle = articleService.saveArticle(markdownContent);
        objectNode.put("success", saveArticle.getFirstValue()).put("isDraft",saveArticle.getLastValue());
        return objectNode.toString();
    }

    @ResponseBody
    @RequestMapping(value = "/getAllLabel",method = RequestMethod.GET)
    public ModelUtil<List<Label>,List<Label>> getAllLabel(){
        return articleService.getAllLabel();
    }
    @RequestMapping(value = "/publish_success")
    public String publishSuccess(){
        return "publish_success";
    }
    @RequestMapping("/article_list")
    public String draftList(){
        return "article_list";
    }
}
