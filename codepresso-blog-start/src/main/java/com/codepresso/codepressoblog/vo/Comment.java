package com.codepresso.codepressoblog.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class Comment {
    Integer id;
    Integer post_id;
    String content;
    String username;
    Date createdAt;

    public Comment(Integer id, Integer post_id, String content, String username) {
        this.id = id;
        this.post_id = post_id;
        this.content = content;
        this.username = username;
    }
}
