package com.nido.bigeventbackend.service;

import com.nido.bigeventbackend.pojo.Category;

import java.util.List;

public interface CategoryService {

    // 新增分类
    public void add(Category category);

    // 列表查询
    public List<Category> list();

    // 根据id查询分类信息
    public Category findById(Integer id);

    // 更新分类
    public void update(Category category);

    // 删除分类
    public void deleteById(Integer id);
}
