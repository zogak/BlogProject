package com.codepresso.todo.controller;

import java.util.List;

import com.codepresso.todo.service.TodoService;
import com.codepresso.todo.vo.ResultDto;
import com.codepresso.todo.vo.Todo;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/todo")
public class TodoController {
    public TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping(method = GET)
    public List<Todo> getTodoList(){
        return todoService.getTodoList();
    }

    @RequestMapping(method = POST)
    public ResultDto addTodo(@RequestBody Todo todo) {
        todoService.addTodo(todo);
        return new ResultDto(200, "Success");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResultDto deleteTodo(@PathVariable(name = "id", required = true) Integer id) {
        todoService.deleteTodo(id);
        return new ResultDto(200, "Success");
    }


}
