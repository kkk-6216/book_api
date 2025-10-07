package com.pro.book_api.mapper;

import com.pro.book_api.dto.BookCreateDto;
import com.pro.book_api.dto.BookDto;
import com.pro.book_api.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public Book toEntity(BookCreateDto dto) {
        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setIsbn(dto.getIsbn());
        book.setAvailableCopies(dto.getAvailableCopies());
        book.setTotalCopies(dto.getTotalCopies());
        return book;
    }

    public BookDto toDto(Book createdBook) {
        BookDto bookDto = new BookDto();
        bookDto.setId(createdBook.getId());
        bookDto.setTitle(createdBook.getTitle());
        bookDto.setAuthor(createdBook.getAuthor());
        bookDto.setIsbn(createdBook.getIsbn());
        bookDto.setAvailableCopies(createdBook.getAvailableCopies());
        bookDto.setTotalCopies(createdBook.getTotalCopies());
        return bookDto;
    }

}
