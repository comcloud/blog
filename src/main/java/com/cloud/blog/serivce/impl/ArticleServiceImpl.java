package com.cloud.blog.serivce.impl;

import com.cloud.blog.entity.Article;
import com.cloud.blog.mapper.ArticleMapper;
import com.cloud.blog.serivce.ArticleService;
import com.cloud.blog.util.JsonUtil;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2021/2/1 12:34
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleMapper articleMapper;

    @Autowired
    public ArticleServiceImpl(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }

    @Override
    public boolean saveArticle(String markdownContent) {
        JsonNode node = JsonUtil.parseJson(markdownContent);
        String title = node.findPath("title").toString();
        String content = node.findPath("content").toString();
        boolean isDraft = node.findPath("isDraft").asBoolean();
        int fatherLabel = node.findPath("fatherLabel").asInt();
        int sonLabel = node.findPath("sonLabel").asInt();
        Article article = new Article();
        article.setTitle(title)
                .setOpenContent(content.length() > 20 ? content.substring(0,20):content)
                .setContent(content)
                .setPublicTime(LocalDateTime.now(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .setFatherLabel(fatherLabel)
                .setSonLabel(sonLabel)
                .setDraft(isDraft);
        return articleMapper.insertArticle(article);
    }
}
