package com.cloud.blog.serivce.impl;

import com.cloud.blog.entity.Article;
import com.cloud.blog.mapper.HomePageMapper;
import com.cloud.blog.serivce.HomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2021/1/29 14:23
 */
@Service
public class HomePageServiceImpl implements HomePageService {

    @Autowired
    private HomePageMapper homePageMapper;

    @Override
    public List<Article> getArticleByFatherId(Integer lid) {
        return homePageMapper.selectArticleByFatherId(lid);
    }

    @Override
    public Article getArticleById(Integer aid) {
        return homePageMapper.selectArticleById(aid);
    }
}
