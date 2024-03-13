package com.Spring.service;

import com.Spring.dto.BlogDto;
import com.Spring.model.Blog;

import java.util.List;
import java.util.Optional;

public interface BlogService {
    List<BlogDto> findAllBlogs();

    Blog saveBlog(Blog blog);

    BlogDto findBlogById(Long blogId);

    void deleteById(Long blogId);

    void updateBlog(BlogDto blogDto);

    Blog BlogById(Long blogId);
}
