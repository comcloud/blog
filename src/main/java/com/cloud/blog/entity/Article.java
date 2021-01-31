package com.cloud.blog.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * (Article)实体类
 *
 * @author makejava
 * @since 2021-01-29 12:11:12
 */
public class Article implements Serializable {
    private static final long serialVersionUID = 634613476280960874L;

    private Integer aid;

    private String title;

    private String openContent;

    private String content;

    private LocalDateTime publicTime;

    private Integer fatherLabel;

    private Integer sonLabel;

    public Integer getAid() {
        return aid;
    }

    public Article setAid(Integer aid) {
        this.aid = aid;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Article setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getOpenContent() {
        return openContent;
    }

    public Article setOpenContent(String openContent) {
        this.openContent = openContent;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Article setContent(String content) {
        this.content = content;
        return this;
    }

    public LocalDateTime getPublicTime() {
        return publicTime;
    }

    public Article setPublicTime(LocalDateTime publicTime) {
        this.publicTime = publicTime;
        return this;
    }

    public Integer getFatherLabel() {
        return fatherLabel;
    }

    public Article setFatherLabel(Integer fatherLabel) {
        this.fatherLabel = fatherLabel;
        return this;
    }

    public Integer getSonLabel() {
        return sonLabel;
    }

    public Article setSonLabel(Integer sonLabel) {
        this.sonLabel = sonLabel;
        return this;
    }

    @Override
    public String toString() {
        return "Article{" +
                "aid=" + aid +
                ", title='" + title + '\'' +
                ", openContent='" + openContent + '\'' +
                ", content='" + content + '\'' +
                ", publicTime=" + publicTime +
                ", fatherLabel=" + fatherLabel +
                ", sonLabel=" + sonLabel +
                '}';
    }
}