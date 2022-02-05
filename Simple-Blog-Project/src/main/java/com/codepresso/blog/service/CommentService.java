package com.codepresso.blog.service;

import com.codepresso.blog.repository.UserCommentRepository;
import com.codepresso.blog.vo.UserComment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private UserCommentRepository userCommentRepository;

    public CommentService(UserCommentRepository userCommentRepository){
        this.userCommentRepository = userCommentRepository;
    }

    public List<UserComment> getComment(int post_id){
        return userCommentRepository.findAllByPostId(post_id);
    }
    public void addComment(UserComment userComment){
        userCommentRepository.save(userComment);
    }
}
