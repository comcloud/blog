package com.cloud.blog.controller;

import com.cloud.blog.entity.Article;
import com.cloud.blog.serivce.ArticleService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2021/2/1 12:07
 */
@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @ResponseBody
    @PostMapping(value = "/saveArticle")
    public String saveArticle(@RequestBody String body) throws UnsupportedEncodingException {
        String markdownContent = URLDecoder.decode(body, "utf-8").trim();
        return JsonNodeFactory.instance.objectNode().put("success", articleService.saveArticle(markdownContent)).toPrettyString();
    }
}
