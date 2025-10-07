package com.pro.book_api.service;

import com.pro.book_api.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.pro.book_api.repository.BookRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    @Transactional
    public Book create(Book entity) {
        return bookRepository.save(entity);
    }

    @Transactional(readOnly = true)
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Книга не найдена с id " + id));
    }

    @Transactional
    public Book update(Long id, Book book) {
        Book bookUpdated = getBookById(id);
        bookUpdated.setTitle(book.getTitle());
        bookUpdated.setAuthor(book.getAuthor());
        bookUpdated.setIsbn(book.getIsbn());
        bookUpdated.setTotalCopies(book.getTotalCopies());
        bookUpdated.setAvailableCopies(book.getAvailableCopies());
        return bookRepository.save(bookUpdated);
    }

    @Transactional
    public void delete(Long id) {
        Book book = getBookById(id);
        bookRepository.delete(book);
    }

}
