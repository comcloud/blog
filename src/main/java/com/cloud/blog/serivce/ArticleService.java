package com.cloud.blog.serivce;

import com.cloud.blog.entity.Label;
import com.cloud.blog.util.ModelUtil;

import java.util.List;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2021/2/1 12:34
 */
public interface ArticleService {
    ModelUtil<Boolean,Boolean> saveArticle(String markdownContent);

    ModelUtil<List<Label>, List<Label>> getAllLabel();

}
