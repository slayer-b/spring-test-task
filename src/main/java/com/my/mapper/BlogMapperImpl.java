package com.my.mapper;

import com.my.domain.Blog;
import com.my.dto.BlogDTO;
import org.springframework.stereotype.Service;

@Service
public class BlogMapperImpl implements BlogMapper {

    public BlogDTO makeBlogDTO(Blog blog) {
        BlogDTO blogDTO = new BlogDTO();
        blogDTO.setId(blog.getId());
        blogDTO.setText(blog.getText());
        blogDTO.setStatus(blog.getStatus());
        blogDTO.setCreated(blog.getCreated());
        blogDTO.setLastUpdated(blog.getLastUpdated());
        return blogDTO;
    }

    public Blog makeBlogEntity(BlogDTO blogDTO) {
        Blog blog = new Blog();
        blog.setId(blogDTO.getId());
        blog.setText(blogDTO.getText());
        blog.setStatus(blogDTO.getStatus());
        blog.setCreated(blogDTO.getCreated());
        blog.setLastUpdated(blogDTO.getLastUpdated());
        return blog;
    }
}
