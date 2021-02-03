package com.cloud.blog.serivce.impl;

import com.cloud.blog.entity.Article;
import com.cloud.blog.entity.Label;
import com.cloud.blog.mapper.ArticleMapper;
import com.cloud.blog.serivce.ArticleService;
import com.cloud.blog.util.JsonUtil;
import com.cloud.blog.util.ModelUtil;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2021/2/1 12:34
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public ModelUtil<Boolean, Boolean> saveArticle(String markdownContent) {
        int lastIndexOf = markdownContent.lastIndexOf("&title");
        String content = markdownContent.substring(0, lastIndexOf);
        markdownContent = markdownContent.substring(lastIndexOf);
        final String[] split = markdownContent.split("&");
        String title = null;
        boolean isDraft = false;
        int fatherLabel = 1, sonLabel = 5;
        for (String s : split) {
            final String[] split1 = s.split("=");
            String result = split1.length < 2 ? "" : split1[1];
            if (s.contains("title")) {
                title = result;
            } else if (s.contains("isDraft")) {
                isDraft = !"false".equals(result);
            } else if (s.contains("fatherLabel")) {
                fatherLabel = Integer.parseInt(result.replace("\"", ""));
            } else if (s.contains("sonLabel")) {
                sonLabel = Integer.parseInt(result.replace("\"", ""));
            }
        }
        content = "\"".equals(content.substring(0, 1)) ? content.substring(1) : content;
        content = "\"".equals(content.substring(content.length() - 1)) ? content.substring(0, content.length() - 1) : content;
        System.out.println(content);
        Article article = new Article();
        article.setTitle(title)
                .setOpenContent(content.length() > 20 ? content.substring(0, 20) : content)
                .setContent(content)
                .setPublicTime(LocalDateTime.now(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .setFatherLabel(fatherLabel)
                .setSonLabel(sonLabel)
                .setDraft(isDraft);
        ModelUtil<Boolean, Boolean> result = new ModelUtil<>();
        result.setFirstValue(articleMapper.insertArticle(article)).setLastValue(isDraft);
        return result;
    }


    @Override
    public ModelUtil<List<Label>, List<Label>> getAllLabel() {
        //第一个为所有父标签，第二个为所有子标签
        List<Label> fatherLabels = articleMapper.selectAllFatherLabel();
        List<Label> sonLabels = articleMapper.selectAllSonLabel();
        return new ModelUtil<>(fatherLabels,sonLabels);
    }
}
