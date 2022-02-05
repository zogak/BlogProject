package com.codepresso.blog.service;


import com.codepresso.blog.repository.PostRepository;
import com.codepresso.blog.vo.Post;
import com.codepresso.blog.vo.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    public List<Post> getPost() {
        return postRepository.findAll();
    }
    public Post getPostById(int id) {
        return postRepository.findById(id);
    }
    public void addPost(Post post){
        postRepository.save(post);
    }
    public void updatePost(Post post){
        postRepository.updatePost(post);
    }
    public void deletePost(int id){
        postRepository.deleteById(id);
    }

}
