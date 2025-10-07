package com.pro.book_api.controller;

import com.pro.book_api.dto.BookCreateDto;
import com.pro.book_api.dto.BookDto;
import com.pro.book_api.mapper.BookMapper;
import com.pro.book_api.model.Book;
import com.pro.book_api.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final BookMapper bookMapper;

    @PostMapping
    public ResponseEntity<BookDto> createBook(@RequestBody BookCreateDto book) {

        Book createdBook = bookService.create(bookMapper.toEntity(book));

        return ResponseEntity.ok(bookMapper.toDto(createdBook));
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks().stream()
                .map(bookMapper::toDto)
                .toList()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookMapper.toDto(bookService.getBookById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDto> updateBook(@PathVariable Long id, @RequestBody BookCreateDto dto) {
        Book updated = bookService.update(id, bookMapper.toEntity(dto));
        return ResponseEntity.ok(bookMapper.toDto(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
