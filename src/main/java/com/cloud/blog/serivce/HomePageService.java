package com.cloud.blog.serivce;

import com.cloud.blog.entity.Article;
import com.cloud.blog.entity.Label;
import com.cloud.blog.util.ModelUtil;

import java.util.List;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2021/1/29 14:23
 */
public interface HomePageService {
    List<Article> getArticleByFatherId(Integer lid);

    Article getArticleById(Integer aid);



}
