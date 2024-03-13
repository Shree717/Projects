package com.Spring.controller;

import com.Spring.dto.BlogDto;
import com.Spring.model.Blog;
import com.Spring.service.BlogService;
import com.Spring.service.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private BlogServiceImpl blogService;
    @Autowired
    public BlogController(BlogServiceImpl blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/blogsCreate")
    public String blogCreate(Model model){
        Blog blog = new Blog();
        model.addAttribute("blogs",blog);
        return "blogs-create";
    }
    @PostMapping("/saveBlog")
    public String blogs(@ModelAttribute("blogs")Blog blog){
        blogService.saveBlog(blog);
        return "redirect:/blogsList";
    }
    @GetMapping("/blogsList")
    public String blogsList(Model model){
        List<BlogDto> blogs = blogService.findAllBlogs();
        model.addAttribute("blogs",blogs);
        return "blogs-list";
    }
    @GetMapping("/post/{blogId}")
    public String blogPost(@PathVariable("blogId") Long blogId,Model model){
        BlogDto blogDto = blogService.findBlogById(blogId);
        model.addAttribute("blog",blogDto);
        return "blogs-post";
    }
    @GetMapping("/post/delete{blogId}")
    public String deleteBlog(@PathVariable("blogId")Long blogId){
        blogService.deleteById(blogId);
        return "redirect:/blogsList";
    }
    @GetMapping("/blog/update{blogId}")
    public String updateBlogForm(@PathVariable("blogId")Long blogId,Model model){
        BlogDto blogDto = blogService.findBlogById(blogId);
        model.addAttribute("blogs",blogDto);
        return "blogs-update";
    }
    @PostMapping("blog/update{blogId}")
    public String updateBlog(@PathVariable("blogId")Long blogId,
                             @ModelAttribute("blogs")BlogDto blog){
        blog.setId(blogId);
        blogService.updateBlog(blog);
        return "redirect:/blogsList";
    }
}
