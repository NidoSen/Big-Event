package com.nido.bigeventbackend.service;

import com.nido.bigeventbackend.pojo.Article;
import com.nido.bigeventbackend.pojo.PageBean;

public interface ArticleService {

    // 新增文章
    public void add(Article article);

    // 条件分页列表查询
    public PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state);
}
