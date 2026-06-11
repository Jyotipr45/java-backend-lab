package com.jash.taskservice.api.v1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageResponseDto<T> {
    private List<T> results;
    private long totalElements;
    private int totalPages;
    private int currentPage;
    private int pageSize;
    private boolean last;
}
