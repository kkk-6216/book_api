package com.pro.book_api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookCreateDto {

    @NotBlank(message = "Название книги обязательно")
    @Size(min = 1, max = 255, message = "Название книги должно быть от 1 до 255 символов")
    private String title;

    @NotBlank(message = "Имя автора обязательно")
    @Size(min = 1, max = 255, message = "Имя автора должно быть от 1 до 255 символов")
    private String author;

    @NotBlank(message = "ISBN обязателен")
    @Size(min = 10, max = 13, message = "ISBN должен содержать от 10 до 13 символов")
    private String isbn;

    @Min(value = 0, message = "Общее количество экземпляров не может быть отрицательным")
    private int totalCopies;

    @Min(value = 0, message = "Доступное количество экземпляров не может быть отрицательным")
    private int availableCopies;

}
