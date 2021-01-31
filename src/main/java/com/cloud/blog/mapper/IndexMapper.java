package com.cloud.blog.mapper;

import com.cloud.blog.entity.Article;
import com.cloud.blog.entity.Label;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.annotation.security.PermitAll;
import java.util.List;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2021/1/29 12:12
 */
@Mapper
public interface IndexMapper {
    public List<Label> selectAllFatherLabel() ;

    List<Article> selectHomePageArticle();

    String selectLabelNameById(@Param("sonLabelId") Integer sonLabelId);

    List<Article> selectHomePageArticleById(@Param("lid") String lid);
}
