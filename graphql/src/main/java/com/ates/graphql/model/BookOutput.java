package com.ates.graphql.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BookOutput {
    private Long id;
    private String title;
    private String authorName;
}
