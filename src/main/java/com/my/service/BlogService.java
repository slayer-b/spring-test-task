package com.my.service;



import com.my.domain.Blog;
import com.my.dto.BlogDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface BlogService {

    List<BlogDTO> getBlogs();

    Optional<BlogDTO> getBlog(Long id);

    BlogDTO create(BlogDTO dto);

    BlogDTO update(BlogDTO dto);

    void delete(Long id);

    List<BlogDTO> findByCreatedBefore(LocalDateTime before);
}
