package com.codepresso.codepressoblog.service;

import com.codepresso.codepressoblog.mapper.CommentMapper;
import com.codepresso.codepressoblog.vo.Comment;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class CommentService {
    private CommentMapper commentMapper;

    public CommentService(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    public Integer getNumOfCommentsOfPost(Integer post_id){
        List<Comment> commentList =  commentMapper.findAllCommentsOfPost(post_id);
        return commentList.size();
    }

    public List<Comment> getCommentsByIdAndPage(Integer post_id, Integer page, Integer size){
        return commentMapper.findByPostIdAndPage(post_id, size, size*(page-1));
    }

    public boolean saveComment(Comment comment){
        Integer result = commentMapper.saveComment(comment);
        return result == 1;
    }

}
