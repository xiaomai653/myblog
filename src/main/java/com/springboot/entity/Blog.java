package com.springboot.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author xiaomai
 * @since 2021-11-01
 */
@Getter
@Setter
public class Blog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 博客ID
     */
    private String id;

    /**
     * 类型
     */
    private String type;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 作者
     */
    private String author;

    /**
     * 发布时间
     */
    private LocalDateTime releaseTime;


}
