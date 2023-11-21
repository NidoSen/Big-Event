package com.nido.bigeventbackend.mapper;

import com.nido.bigeventbackend.pojo.Category;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
}
