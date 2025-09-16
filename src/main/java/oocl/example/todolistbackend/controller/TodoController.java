package oocl.example.todolistbackend.controller;

import lombok.Getter;
import lombok.Setter;
import oocl.example.todolistbackend.dto.CreateTodoReq;
import oocl.example.todolistbackend.entity.TodoEntity;
import oocl.example.todolistbackend.service.TodoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

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

//    @PostMapping("/todos")
//    public ResponseEntity<TodoEntity> createTodo(CreateTodoReq createTodoReq) {
//        TodoEntity todoEntity = new TodoEntity();
//        BeanUtils.copyProperties(createTodoReq, todoEntity);
//        TodoEntity savedTodo = todoService.addTodo(todoEntity);
//        return ResponseEntity.status(201).body(savedTodo);
//    }

}
