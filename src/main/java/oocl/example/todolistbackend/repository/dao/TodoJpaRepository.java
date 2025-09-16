package oocl.example.todolistbackend.repository.dao;

import oocl.example.todolistbackend.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoJpaRepository extends JpaRepository<TodoEntity, Long> {

}
