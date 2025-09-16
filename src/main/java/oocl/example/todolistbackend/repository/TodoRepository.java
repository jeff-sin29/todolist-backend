package oocl.example.todolistbackend.repository;

import oocl.example.todolistbackend.entity.TodoEntity;

import java.util.List;

public interface TodoRepository {
    public List<TodoEntity> getTodos();

    public TodoEntity addTodo(TodoEntity todoEntity);

    public void clear();

    public TodoEntity getTodoById(long id);

    public TodoEntity updateTodoById(long id, TodoEntity updatedTodoEntity);

    public void deleteTodoById(long id);
}
