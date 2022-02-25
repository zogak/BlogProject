package com.codepresso.todo.repository;

import com.codepresso.todo.vo.Todo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TodoRepository {
    void save(@Param("todo") Todo todo);
    List<Todo> findAll();
    void deleteById(@Param("id") Integer id);
}