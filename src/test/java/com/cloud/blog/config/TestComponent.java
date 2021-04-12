package com.cloud.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.cloud.blog.entity.Label;
/**
 * @author 成都犀牛
 * @version 1.0
 * @datetime 2021/3/16 9:28 上午
 */
@Component
public class TestComponent {

    @Bean
    public Label getLabel(){
        return new Label();
    }
}
