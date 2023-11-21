package com.nido.bigeventbackend.controller;

import com.nido.bigeventbackend.pojo.Article;
import com.nido.bigeventbackend.pojo.Result;
import com.nido.bigeventbackend.service.ArticleService;
import com.nido.bigeventbackend.utils.JwtUtil;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping
    public Result add(@RequestBody @Validated Article article) {
        articleService.add(article);
        return Result.success();
    }
}
