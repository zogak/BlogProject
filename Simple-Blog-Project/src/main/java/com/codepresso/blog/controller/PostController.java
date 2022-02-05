package com.codepresso.blog.controller;

import com.codepresso.blog.service.PostService;
import com.codepresso.blog.vo.Post;
import com.codepresso.blog.vo.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostController {
    private PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getPost() {
        return postService.getPost();
    }
    @GetMapping(value = "/{id}")
    public Post getPostById(@PathVariable(name = "id") Integer id) {
        return postService.getPostById(id);
    }
    @PostMapping
    public Result addPost(@RequestBody Post post){
        postService.addPost(post);
        return new Result(200, "success");
    }
    @DeleteMapping
    public Result deletePost(@RequestParam(name = "id") Integer id){
        postService.deletePost(id);
        return new Result(200, "success");
    }
    @PutMapping
    public Result updatePost(@RequestBody Post post){
        postService.updatePost(post);
        return new Result(200, "success");
    }

}
