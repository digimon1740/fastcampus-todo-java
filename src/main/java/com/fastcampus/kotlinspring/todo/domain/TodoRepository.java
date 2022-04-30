package com.fastcampus.kotlinspring.todo.domain;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    Optional<List<Todo>> findAllByDoneIsFalseOrderByIdDesc();
}
