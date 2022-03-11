package com.codepresso.codepressoblog.mapper;

import com.codepresso.codepressoblog.vo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {
    List<Comment> findAllCommentsOfPost(@Param("post_id") Integer post_id);
    List<Comment> findByPostIdAndPage(@Param("post_id") Integer post_id, @Param("limit") Integer limit, @Param("offset") Integer offset);

    Integer numOfCommentsOfPost(@Param("post_id") Integer post_id);
    List<Comment> findCommentsOfPostByLimit(@Param("limit") Integer limit, @Param("offset") Integer offset);
    Integer saveComment(@Param("comment") Comment comment);
    Integer updateComment(@Param("comment") Comment comment);
    Integer deleteComment(@Param("id") Integer id);
}
