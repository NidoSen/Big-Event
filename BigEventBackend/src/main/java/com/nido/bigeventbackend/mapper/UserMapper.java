package com.nido.bigeventbackend.mapper;

import com.nido.bigeventbackend.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {

    @Select("select * from user where username = #{username}")
    public User findByUsername(String username);

    @Insert("insert into user(username, password, create_time, update_time) " +
            "values(#{username}, #{password}, now(), now())")
    public void add(String username, String password);

    @Update("update user set nickname=#{nickname}, email=#{email}, update_time=#{updateTime} where id=#{id}")
    public void update(User user);
}
