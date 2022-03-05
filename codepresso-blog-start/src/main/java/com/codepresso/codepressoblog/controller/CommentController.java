package com.codepresso.codepressoblog.controller;

import com.codepresso.codepressoblog.controller.dto.CommentRequestDto;
import com.codepresso.codepressoblog.controller.dto.CommentResponseDto;
import com.codepresso.codepressoblog.controller.dto.PostResponseDto;
import com.codepresso.codepressoblog.service.CommentService;
import com.codepresso.codepressoblog.vo.Comment;
import com.codepresso.codepressoblog.vo.Post;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

//    @GetMapping("/comment")
//    public Integer getNumOfCommentsOfPost(@RequestParam Integer post_id){
//        return commentService.getNumOfCommentsOfPost(post_id);
//    }

//    @GetMapping("/comment")
//    public List<Comment> getAllCommentsOfPost(@RequestParam Integer post_id){
//        return commentService.getAllCommentsOfPost(post_id);
//    }

    @GetMapping("/comment")
    public List<CommentResponseDto> getCommentsByIdAndPage(@RequestParam Integer post_id, Integer page){
        List<Comment> comments = commentService.getCommentsByIdAndPage(post_id, page, 3);

        List<CommentResponseDto> commentResponseDtoList= new ArrayList<>();
        for (Comment comment : comments){
            commentResponseDtoList.add(new CommentResponseDto(comment));
        }

        return commentResponseDtoList;
    }

    @PostMapping("/comment")
    public String createComment(@RequestBody CommentRequestDto commentDto){
        Comment comment = commentDto.getComment();
        commentService.saveComment(comment);

        return "success";
    }
}
