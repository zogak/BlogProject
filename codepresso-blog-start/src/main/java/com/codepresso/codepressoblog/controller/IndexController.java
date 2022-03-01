package com.codepresso.codepressoblog.controller;

import com.codepresso.codepressoblog.mapper.PostMapper;
import com.codepresso.codepressoblog.service.PostService;
import com.codepresso.codepressoblog.vo.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
    private PostService postService;

    public IndexController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping(value = "/")
    public String index(Model model) {
        List<Post> posts = postService.getPostByPage(1, 3);
        model.addAttribute("posts", posts);
        return "index";
    }
}
