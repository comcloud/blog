package com.cloud.blog.serivce;

import com.cloud.blog.entity.Article;
import com.cloud.blog.entity.Label;
import com.cloud.blog.util.ModelUtil;

import java.util.List;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2021/1/29 12:09
 */
public interface IndexService {
    List<Label> getAllFatherLabel();

    List<ModelUtil<Article,String>> getHomePageArticle();

    List<ModelUtil<Article, String>> getHomePageArticleById(String lid);


}
