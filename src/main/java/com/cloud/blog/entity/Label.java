package com.cloud.blog.entity;

import java.io.Serializable;

/**
 * (Label)实体类
 *
 * @author makejava
 * @since 2021-01-29 12:11:14
 */
public class Label implements Serializable {
    private static final long serialVersionUID = -84190586493486544L;

    private Integer lid;

    private String name;

    private Integer fatherLabelId;


    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFatherLabelId() {
        return fatherLabelId;
    }

    public void setFatherLabelId(Integer fatherLabelId) {
        this.fatherLabelId = fatherLabelId;
    }

}