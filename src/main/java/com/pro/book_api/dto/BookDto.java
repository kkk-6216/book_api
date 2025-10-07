package com.pro.book_api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDto {

    private Long id;

    private String title;

    private String author;

    private String isbn;

    private int totalCopies;

    private int availableCopies;

}
