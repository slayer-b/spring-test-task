package com.my.dto;

import java.util.List;

public class BlogListDTO {

    List<BlogDTO> dtos;

    public BlogListDTO(List<BlogDTO> dtos) {
        this.dtos = dtos;
    }

    public List<BlogDTO> getDtos() {
        return dtos;
    }

    public void setDtos(List<BlogDTO> dtos) {
        this.dtos = dtos;
    }
}
