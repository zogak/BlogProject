package com.codepresso.codepressoblog.controller.dto;

import com.codepresso.codepressoblog.vo.Comment;
import lombok.Setter;

@Setter
public class CommentRequestDto {
    Integer id;
    Integer post_id;
    String content;
    String username;

    public Comment getComment() {
        return new Comment(this.id, this.post_id, this.content, this.username);
    }
}
