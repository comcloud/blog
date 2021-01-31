package com.cloud.blog.mapper;

import com.cloud.blog.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.annotation.security.PermitAll;
import java.util.List;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2021/1/29 14:27
 */
@Mapper
public interface HomePageMapper {
    List<Article> selectArticleByFatherId(@Param("lid") Integer lid);


    Article selectArticleById(@Param("aid") Integer aid);
}
