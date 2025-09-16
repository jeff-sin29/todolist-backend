package oocl.example.todolistbackend.repository;

import oocl.example.todolistbackend.entity.TodoEntity;

import java.util.List;

public interface TodoRepository {
    public List<TodoEntity> getTodos();

    public void addTodo(TodoEntity todoEntity);

    public void clear();

}
