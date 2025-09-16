package oocl.example.todolistbackend.controller;

import lombok.Getter;
import lombok.Setter;
import oocl.example.todolistbackend.dto.CreateTodoReq;
import oocl.example.todolistbackend.dto.UpdateTodoReq;
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

    @PutMapping("/todos/{id}")
    public ResponseEntity<TodoEntity> updateTodo(@PathVariable Long id, @RequestBody UpdateTodoReq updateTodoReq) {
        TodoEntity todoEntity = new TodoEntity();
        BeanUtils.copyProperties(updateTodoReq, todoEntity);
        return ResponseEntity.status(200).body(todoService.updateTodoById(id, todoEntity));
    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        // Since there's no delete method in the service/repository, we'll just return 204 No Content
        todoService.deleteTodoById(id);
        return ResponseEntity.noContent().build();
    }

}
