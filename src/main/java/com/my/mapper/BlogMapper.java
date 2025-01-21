package com.my.mapper;

import com.my.domain.Blog;
import com.my.dto.BlogDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BlogMapper {

    BlogDTO makeBlogDTO(Blog blog);

    Blog makeBlogEntity(BlogDTO blogDTO);

}
