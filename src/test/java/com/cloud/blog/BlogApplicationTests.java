package com.cloud.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cloud.blog.entity.Label;
import com.cloud.blog.entity.Article;
@SpringBootTest
class BlogApplicationTests {

    @Autowired
    private Article article;

    @Autowired
    private Label label;

    @Test
    void contextLoads() {
        System.out.println(article.hashCode());
        System.out.println(label);
    }

}
