package com.springboot.mapper;

import com.springboot.entity.Blog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xiaomai
 * @since 2021-11-01
 */

@Mapper
public interface BlogMapper extends BaseMapper<Blog> {

}
