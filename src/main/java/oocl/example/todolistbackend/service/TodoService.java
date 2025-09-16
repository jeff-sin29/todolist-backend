package oocl.example.todolistbackend.service;

import lombok.Getter;
import lombok.Setter;
import oocl.example.todolistbackend.entity.TodoEntity;
import oocl.example.todolistbackend.exception.IncompleteUpdatePayloadException;
import oocl.example.todolistbackend.exception.InvalidTextFieldException;
import oocl.example.todolistbackend.exception.MissingTextFieldException;
import oocl.example.todolistbackend.exception.UpdateNonExistingIdException;
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
        if (todoEntity.getText() == null) {
            throw new InvalidTextFieldException();
        } else if (todoEntity.getText().trim().isEmpty()){
            throw new MissingTextFieldException();
        }
        todoEntity.setDone(false);
        return todoRepository.addTodo(todoEntity);
    }

    public TodoEntity updateTodoById(long id, TodoEntity updatedTodoEntity) {
        TodoEntity todoEntity = todoRepository.updateTodoById(id, updatedTodoEntity);
        if (todoEntity == null){
            throw new UpdateNonExistingIdException();
        } else {
            return todoEntity;
        }
    }

    public void clearTodoList() {
        todoRepository.clear();
    }


}
