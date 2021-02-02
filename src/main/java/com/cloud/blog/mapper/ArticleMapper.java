package com.cloud.blog.mapper;

import com.cloud.blog.entity.Article;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2021/2/2 14:25
 */
@Mapper
public interface ArticleMapper {
    boolean insertArticle(Article article);
}
