package com.Spring.service;

import com.Spring.dto.BlogDto;
import com.Spring.model.Blog;
import com.Spring.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BlogServiceImpl implements BlogService{

    private BlogRepository blogRepository;
    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public List<BlogDto> findAllBlogs() {
        List<Blog> blogs = blogRepository.findAll();
        return blogs.stream().map((blog) -> mapToBlogDto(blog)).collect(Collectors.toList());
    }

    private BlogDto mapToBlogDto(Blog blog) {
        BlogDto blogDto = BlogDto.builder()
                .id(blog.getId())
                .title(blog.getTitle())
                .photoUrl(blog.getPhotoUrl())
                .date(blog.getDate())
                .content(blog.getContent())
                .build();
        return blogDto;
    }
    @Override
    public Blog saveBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public BlogDto findBlogById(Long blogId) {
        Blog blog = blogRepository.findById(blogId).get();
        return mapToBlogDto(blog);
    }

    @Override
    public void deleteById(Long blogId) {
       blogRepository.deleteById(blogId);
    }

    @Override
    public void updateBlog(BlogDto blogDto) {
        Blog blog = mapToBlog(blogDto);
        blogRepository.save(blog);
    }

    private Blog mapToBlog(BlogDto blogDto){
        Blog blog = Blog.builder()
                .photoUrl(blogDto.getPhotoUrl())
                .title(blogDto.getTitle())
                .date(blogDto.getDate())
                .content(blogDto.getContent())
                .build();

        return blog;
    }

    @Override
    public Blog BlogById(Long blogId) {
        return blogRepository.findById(blogId).get();
    }


}
