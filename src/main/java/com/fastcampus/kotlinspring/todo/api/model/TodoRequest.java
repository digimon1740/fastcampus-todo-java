package com.fastcampus.kotlinspring.todo.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoRequest {

    private String title;

    private String description;

    private Boolean done = false;
}
