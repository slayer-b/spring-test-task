package com.my.mapper;

import com.my.domain.Blog;
import com.my.dto.BlogDTO;

public interface BlogMapper {

    BlogDTO makeBlogDTO(Blog blog);

    Blog makeBlogEntity(BlogDTO blogDTO);
}
