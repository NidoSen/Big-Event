package com.nido.bigeventbackend.mapper;

import com.nido.bigeventbackend.pojo.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleMapper {

    // 新增
    @Insert("insert into article(title, content, cover_img, state, category_id, create_user, create_time, update_time) " +
            "values(#{title}, #{content}, #{coverImg}, #{state}, #{categoryId}, #{createUser}, #{createTime}, #{updateTime})")
    public void add(Article article);

    public List<Article> list(Integer userId, Integer categoryId, String state);

    @Select("select * from article where id=#{id}")
    public Article findById(Integer id);

    @Update("update article set title=#{title}, content=#{content}, cover_img=#{coverImg}, state=#{state}, category_id=#{categoryId}, " +
            "update_time=#{updateTime} where id=#{id}")
    public void update(Article article);

    @Delete("delete from article where id=#{id}")
    public void deleteById(Integer id);
}
