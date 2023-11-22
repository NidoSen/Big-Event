package com.nido.bigeventbackend.service;

import com.nido.bigeventbackend.pojo.Article;
import com.nido.bigeventbackend.pojo.PageBean;

public interface ArticleService {

    // 新增文章
    public void add(Article article);

    // 条件分页列表查询
    public PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state);

    // 根据id查询
    public Article findById(Integer id);

    // 更新
    public void update(Article article);

    // 根据id删除
    public void deleteById(Integer id);
}
