package com.cloud.blog.mapper;

import com.cloud.blog.entity.Article;
import com.cloud.blog.entity.Label;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2021/2/2 14:25
 */
@Mapper
public interface ArticleMapper {
    boolean insertArticle(@Param("article")Article article);

    List<Label> selectAllFatherLabel();


    List<Label> selectAllSonLabel();

}
