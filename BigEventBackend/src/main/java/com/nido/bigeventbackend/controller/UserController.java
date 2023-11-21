package com.nido.bigeventbackend.controller;

import com.nido.bigeventbackend.pojo.Result;
import com.nido.bigeventbackend.pojo.User;
import com.nido.bigeventbackend.service.UserService;
import com.nido.bigeventbackend.utils.JwtUtil;
import com.nido.bigeventbackend.utils.Md5Util;
import com.nido.bigeventbackend.utils.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{5,16}") String username,
                           @Pattern(regexp = "^\\S{5,16}") String password) {

        User u = userService.findByUsername(username);

        if (u == null) {
            userService.register(username, password);
            return Result.success();
        }
        else {
            return Result.error("用户名已被占用");
        }
    }

    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{5,16}") String username,
                                @Pattern(regexp = "^\\S{5,16}") String password) {
        User loginUser = userService.findByUsername(username);
        if (loginUser == null) {
            return Result.error("用户名错误");
        }

        if (Md5Util.getMD5String(password).equals(loginUser.getPassword())) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", loginUser.getId());
            claims.put("username", loginUser.getUsername());

            String token = JwtUtil.genToken(claims);

            return Result.success(token);
        }
        else {
            return Result.error("密码错误");
        }
    }

    @GetMapping ("/userInfo")
    public Result<User> userInfo(/*@RequestHeader(name = "Authorization") String token*/) {
        // 根据用户名查询用户
        /*Map<String, Object> map = JwtUtil.parseToken(token);
        String username = (String)map.get("username");*/
        Map<String, Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");

        User user = userService.findByUsername(username);
        return Result.success(user);
    }

    @PutMapping("/update")
    public Result update(@RequestBody @Validated User user) {
        userService.update(user);
        return Result.success();
    }

    @PatchMapping("/updateAvatar")
    public Result updateAvatar(@RequestParam @URL String avatarUrl) {
        userService.updateAvatar(avatarUrl);
        return Result.success();
    }

    @PatchMapping("/updatePwd")
    public Result updatePwd(@RequestBody Map<String, String> params) {
        // 1.校验参数
        String oldPwd = params.get("old_pwd");
        String newPwd = params.get("new_pwd");
        String rePwd = params.get("re_pwd");

        if (!StringUtils.hasLength(oldPwd) || !StringUtils.hasLength(newPwd) || !StringUtils.hasLength(rePwd)) {
            return Result.error("缺少必要的参数");
        }

        // 原密码是否正确
        // 调用UserService根据用户名拿到原密码，再和old_pwd比较
        Map<String, Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        User loginUser = userService.findByUsername(username);
        if (!loginUser.getPassword().equals(Md5Util.getMD5String(oldPwd))) {
            return Result.error("原密码填写不正确");
        }

        // newPwd和rePwd是否一样
        if (!rePwd.equals(newPwd)) {
            return Result.error("两次填写的密码不一样");
        }

        // 2.调用service完成密码更新
        userService.updatePwd(newPwd);
        return Result.success();
    }
}
