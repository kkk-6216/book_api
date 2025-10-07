package com.pro.book_api.controller;

import com.pro.book_api.dto.BookCreateDto;
import com.pro.book_api.dto.BookDto;
import com.pro.book_api.mapper.BookMapper;
import com.pro.book_api.model.Book;
import com.pro.book_api.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
@Tag(name = "Книги", description = "Endpoint-ы для книг")
public class BookController {

    private final BookService bookService;
    private final BookMapper bookMapper;

    @PostMapping
    @Operation(summary = "Добавить книгу")
    public ResponseEntity<BookDto> createBook(@RequestBody @Valid BookCreateDto book) {

        Book createdBook = bookService.create(bookMapper.toEntity(book));

        return ResponseEntity.ok(bookMapper.toDto(createdBook));
    }

    @GetMapping
    @Operation(summary = "Получить список всех книг")
    public ResponseEntity<List<BookDto>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks().stream()
                .map(bookMapper::toDto)
                .toList()
        );
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить книгу по ID")
    public ResponseEntity<BookDto> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookMapper.toDto(bookService.getBookById(id)));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Редактировать книгу по ID")
    public ResponseEntity<BookDto> updateBook(@PathVariable Long id, @Valid @RequestBody BookCreateDto dto) {
        Book updated = bookService.update(id, bookMapper.toEntity(dto));
        return ResponseEntity.ok(bookMapper.toDto(updated));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить книгу по ID")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
