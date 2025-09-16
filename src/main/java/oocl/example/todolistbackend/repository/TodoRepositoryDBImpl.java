package oocl.example.todolistbackend.repository;

import oocl.example.todolistbackend.entity.TodoEntity;
import oocl.example.todolistbackend.repository.dao.TodoJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TodoRepositoryDBImpl implements TodoRepository {

    @Autowired
    private TodoJpaRepository todoJpaRepository;

    @Override
    public List<TodoEntity> getTodos() {
        return todoJpaRepository.findAll();
    }

    @Override
    public TodoEntity addTodo(TodoEntity todo) {
        return todoJpaRepository.save(todo);
    }

    @Override
    public void clear() {
        todoJpaRepository.deleteAll();
    }
}
