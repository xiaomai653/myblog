package com.springboot.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.config.Result;
import com.springboot.entity.Blog;
import com.springboot.entity.BlogForm;
import com.springboot.service.IBlogService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xiaomai
 * @since 2021-11-01
 */
@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    IBlogService blogService;

    @PostMapping("/add")
    public Result add(@RequestBody Blog blog){
        boolean save = blogService.save(blog);
        if (save) {
            return Result.success();
        }else {
            return Result.fail();
        }
    }

    @PostMapping("/list")
    public List<Blog> list(@RequestBody Blog blog){
        LambdaQueryWrapper<Blog> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(blog.getType()),Blog::getType,blog.getType());
        return blogService.list(queryWrapper);
    }

    @PostMapping("/page")
    public Result page(@RequestBody BlogForm blogForm){
        LambdaQueryWrapper<Blog> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(blogForm.getType()),Blog::getType,blogForm.getType());
        return Result.success(blogService.page(new Page<>(blogForm.getCurrent(),blogForm.getSize()), queryWrapper));
    }

    @GetMapping("/detail")
    public Blog detail(@RequestParam String id){
        return blogService.getById(id);
    }

    @GetMapping("/getType")
    public Result getType() {
        List<Blog> list = blogService.list(new LambdaQueryWrapper<Blog>().groupBy(Blog::getType).select(Blog::getType));
        return Result.success(list);
    }


}

