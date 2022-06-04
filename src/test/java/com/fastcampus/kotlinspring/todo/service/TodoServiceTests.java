package com.fastcampus.kotlinspring.todo.service;

import com.fastcampus.kotlinspring.todo.domain.Todo;
import com.fastcampus.kotlinspring.todo.domain.TodoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
public class TodoServiceTests {

    @MockBean
    private TodoRepository repository;

    private TodoService service;

    private Todo stub;

    @BeforeEach
    public void setUp() {
        service = new TodoService(repository);
        stub = todoStub();
    }

    @Test
    public void 한개의_TODO를_반환해야한다() {
        // Given
        given(repository.findById(1L)).willReturn(Optional.of(stub));

        // When
        Todo actual = service.findById(1L);

        // Then
        assertThat(actual).isNotNull();
        assertThat(actual).isEqualTo(stub);
    }


    public Todo todoStub() {
        return Todo.builder()
                .id(1L)
                .title("테스트")
                .description("테스트 상세")
                .done(false)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now()).build();
    }


}
