package com.my.service;

import com.my.domain.Blog;
import com.my.dto.BlogDTO;
import com.my.mapper.BlogMapper;
import com.my.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BlogServiceImpl implements BlogService {

    /**
     * Injecting dependencies
     */
    private final BlogMapper blogMapper;
    private final BlogRepository blogRepository;

    @Autowired
    public BlogServiceImpl(BlogMapper blogMapper, BlogRepository blogRepository) {
        this.blogMapper = blogMapper;
        this.blogRepository = blogRepository;
    }

    @Override
    public List<BlogDTO> getBlogs() {
        return blogRepository.findAll()
                .stream()
                .map(blogMapper::makeBlogDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<BlogDTO> getBlog(Long id) {
        Optional<Blog> rez = blogRepository.findById(id);
        return rez.map(x -> blogMapper.makeBlogDTO(x));
    }

    @Override
    public BlogDTO create(BlogDTO dto) {
        dto.setCreated(LocalDateTime.now());
        Blog blog = blogMapper.makeBlogEntity(dto);
        Blog rez = blogRepository.save(blog);
        return blogMapper.makeBlogDTO(rez);
    }

    @Override
    public BlogDTO update(BlogDTO dto) {
        dto.setLastUpdated(LocalDateTime.now());
        Blog blog = blogMapper.makeBlogEntity(dto);
        blogRepository.getReferenceById(blog.getId());//check if entity exists
        Blog rez = blogRepository.save(blog);
        return blogMapper.makeBlogDTO(rez);
    }

    @Override
    public void delete(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public List<BlogDTO> findByCreatedBefore(LocalDateTime before) {
        return blogRepository.findByCreatedBefore(before)
                .stream()
                .map(blogMapper::makeBlogDTO)
                .collect(Collectors.toList());
    }
}
