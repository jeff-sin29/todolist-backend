package oocl.example.todolistbackend.repository;

import oocl.example.todolistbackend.entity.TodoEntity;

import java.util.List;

public interface TodoRepository {
    List<TodoEntity> getTodos();

    TodoEntity addTodo(TodoEntity todoEntity);

    void clear();

    TodoEntity getTodoById(long id);

    TodoEntity updateTodoById(long id, TodoEntity updatedTodoEntity);

    void deleteTodoById(long id);
}
