package oocl.example.todolistbackend.service;

import lombok.Getter;
import lombok.Setter;
import oocl.example.todolistbackend.entity.TodoEntity;
import oocl.example.todolistbackend.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public List<TodoEntity> getTodos() {
        return todoRepository.getTodos();
    }

    public TodoEntity addTodo(TodoEntity todoEntity) {
        todoEntity.setDone(false);
        return todoRepository.addTodo(todoEntity);
    }

    public void clearTodoList() {
        todoRepository.clear();
    }


}
