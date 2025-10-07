package com.pro.book_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.pro.book_api.repository.BookRepository;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

}
