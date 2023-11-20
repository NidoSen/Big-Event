package com.nido.bigeventbackend.controller;

import com.nido.bigeventbackend.pojo.Result;
import com.nido.bigeventbackend.utils.JwtUtil;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @GetMapping("/list")
    public Result<String> list(/*@RequestHeader(name = "Authorization", required = false) String token,
                               HttpServletResponse response*/) {
        /*try {
            Map<String, Object> claims =  JwtUtil.parseToken(token);
            System.out.println("1");
            return Result.success("所有文章数据");
        } catch (Exception e) {
            response.setStatus(401);
            return Result.error("未登录");
        }*/

        return Result.success("所有文章数据");
    }
}
