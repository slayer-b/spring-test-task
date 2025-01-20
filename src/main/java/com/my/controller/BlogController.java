package com.my.controller;

import com.my.dto.BlogDTO;
import com.my.dto.BlogListDTO;
import com.my.dto.ErrorDTO;
import com.my.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class BlogController {

    private BlogService blogService;


    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

//    @GetMapping(value = {"/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping(value = {""})
    @ResponseStatus(HttpStatus.OK)
    public BlogListDTO getBlogs() {
        return new BlogListDTO(blogService.getBlogs());
    }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public BlogDTO postBlog(@RequestBody BlogDTO dto) {
        return blogService.create(dto);
    }

    @PutMapping(value = {"/"})
    @ResponseStatus(HttpStatus.OK)
    public BlogDTO putBlog(@RequestBody BlogDTO dto) {
        return blogService.update(dto);
    }

    @DeleteMapping(value = {"/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteBlog(@PathVariable Long id) {
        blogService.delete(id);
    }

    @GetMapping(value = {"/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public BlogDTO getBlog(@PathVariable Long id) {
        Optional<BlogDTO> blog = blogService.getBlog(id);
        return blog.orElseThrow();
    }

    @GetMapping(value = {"/createdBefore/{before}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<BlogDTO> getCreatedBefore(@PathVariable LocalDateTime before) {
        //format: 2025-01-20T09:49:39.939585
        return blogService.findByCreatedBefore(before);
    }

    @ExceptionHandler(Exception.class)
    public ErrorDTO exception(Exception e) {
        return new ErrorDTO(e.getClass(), e.getMessage());
    }


}
