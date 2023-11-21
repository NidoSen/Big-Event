package com.nido.bigeventbackend.service;

import com.nido.bigeventbackend.pojo.User;

public interface UserService {

    public User findByUsername(String username);

    public void register(String username, String password);

    // 更新
    public void update(User user);
}
