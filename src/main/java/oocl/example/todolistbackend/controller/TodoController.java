package oocl.example.todolistbackend.controller;

import lombok.Getter;
import lombok.Setter;
import oocl.example.todolistbackend.dto.CreateTodoReq;
import oocl.example.todolistbackend.entity.TodoEntity;
import oocl.example.todolistbackend.service.TodoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@Getter
@Setter
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/todos")
    public ResponseEntity<List<TodoEntity>> getTodos() {
        return ResponseEntity.ok(todoService.getTodos());
    }

    @PostMapping("/todos")
    public ResponseEntity<TodoEntity> createTodo(@RequestBody CreateTodoReq createTodoReq) {
        TodoEntity todoEntity = new TodoEntity();
        BeanUtils.copyProperties(createTodoReq, todoEntity);
        TodoEntity savedTodo = todoService.addTodo(todoEntity);
        return ResponseEntity.status(201).body(savedTodo);
    }

}
