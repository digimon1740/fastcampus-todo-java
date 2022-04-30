package com.fastcampus.kotlinspring.todo.api.model;

import com.fastcampus.kotlinspring.todo.domain.Todo;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;
import org.springframework.util.Assert;

@Data
@Builder
public class TodoResponse {

    private Long id;

    private String title;

    private String description;

    private Boolean done;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public static TodoResponse of(Todo todo) {
        Assert.notNull(todo, "Todo is null");

        return TodoResponse.builder()
            .id(todo.getId())
            .title(todo.getTitle())
            .description(todo.getDescription())
            .done(todo.getDone())
            .createdAt(todo.getCreatedAt())
            .updatedAt(todo.getUpdatedAt())
            .build();
    }

}
