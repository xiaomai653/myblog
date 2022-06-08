package com.springboot.service.impl;

import com.springboot.entity.Blog;
import com.springboot.mapper.BlogMapper;
import com.springboot.service.IBlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xiaomai
 * @since 2021-11-01
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements IBlogService {

}
