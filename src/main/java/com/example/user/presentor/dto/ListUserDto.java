package com.example.user.presentor.dto;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.Min;

public class ListUserDto {
    @Min(value = 0)
    private Integer page;

    @Min(value = 0)
    private Integer limit;

    public Integer getPage() { return page;}
    public Integer getLimit() {return limit;}

    public void setPage(Integer page) {
        this.page = page;
    }

    public void  setLimit(Integer limit) {
        this.limit = limit;
    }
}
