package com.cloud.blog.serivce.impl;

import com.cloud.blog.entity.Article;
import com.cloud.blog.entity.Label;
import com.cloud.blog.mapper.IndexMapper;
import com.cloud.blog.serivce.IndexService;
import com.cloud.blog.util.ModelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2021/1/29 12:09
 */
@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private IndexMapper indexMapper;

    @Override
    public List<Label> getAllFatherLabel() {
        return indexMapper.selectAllFatherLabel();
    }

    @Override
    public List<ModelUtil<Article, String>> getHomePageArticle() {
        return getArticles(null);
    }

    @Override
    public List<ModelUtil<Article, String>> getHomePageArticleById(String lid) {
        return getArticles(lid);
    }


    private List<ModelUtil<Article, String>> getArticles(String lid) {
        List<ModelUtil<Article, String>> list = new ArrayList<>();

        List<Article> articleList = null == lid ? indexMapper.selectHomePageArticle() : indexMapper.selectHomePageArticleById(lid);
        articleList.forEach(article -> {
            ModelUtil<Article, String> modelUtil = new ModelUtil<>();
            modelUtil.setFirstValue(article).setLastValue(indexMapper.selectLabelNameById(article.getSonLabel()));
            list.add(modelUtil);
        });
        return list;
    }
}
