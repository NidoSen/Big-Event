package com.nido.bigeventbackend.service;

import com.nido.bigeventbackend.pojo.User;

public interface UserService {

    // 根据用户名查询用户
    public User findByUsername(String username);

    // 注册
    public void register(String username, String password);

    // 更新
    public void update(User user);

    // 更新头像
    public void updateAvatar(String avatarUrl);

    // 更新密码
    public void updatePwd(String newPwd);
}
