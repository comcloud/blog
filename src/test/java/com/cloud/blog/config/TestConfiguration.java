package com.cloud.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloud.blog.entity.Article;
/**
 * @author 成都犀牛
 * @version 1.0
 * @datetime 2021/3/16 9:27 上午
 */
@Configuration
public class TestConfiguration {

    @Bean
    public Article getArticle(){
        return new Article();
    }
}
