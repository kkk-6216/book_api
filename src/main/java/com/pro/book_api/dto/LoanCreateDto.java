package com.pro.book_api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoanCreateDto {

    @NotNull(message = "Книга обязательна")
    private Long bookId;

    @NotNull(message = "Читатель обязателен")
    private Long readerId;

}
