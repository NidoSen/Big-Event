package com.nido.bigeventbackend.mapper;

import com.nido.bigeventbackend.pojo.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryMapper {

    // 新增
    @Insert("insert into category(category_name, category_alias, create_user, create_time, update_time) " +
            "values(#{categoryName}, #{categoryAlias}, #{createUser}, #{createTime}, #{updateTime})")
    public void add(Category category);

    // 查询所有
    @Select("select * from category where create_user=#{userId}")
    public List<Category> list(Integer userId);

    // 根据id查询
    @Select("select * from category where id=#{id}")
    public Category findById(Integer id);

    // 更新
    @Update("update category set category_name=#{categoryName}, category_alias=#{categoryAlias}, update_time=#{updateTime}" +
            "where id=#{id}")
    public void update(Category category);

    // 根据id删除
    @Delete("delete from category where id=#{id}")
    public void deleteById(Integer id);
}
