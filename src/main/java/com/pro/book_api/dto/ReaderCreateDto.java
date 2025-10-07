package com.pro.book_api.dto;

import jakarta.validation.constraints.Email;
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
public class ReaderCreateDto {

    @NotBlank(message = "Имя обязательно")
    @Size(min = 1, max = 255, message = "Имя должно быть от 1 до 255 символов")
    private String name;

    @NotBlank(message = "Email обязателен")
    @Email(message = "Email должен быть валидным")
    private String email;

}
