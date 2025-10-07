package com.pro.book_api.controller;

import com.pro.book_api.dto.LoanCreateDto;
import com.pro.book_api.dto.LoanDto;
import com.pro.book_api.mapper.LoanMapper;
import com.pro.book_api.model.Book;
import com.pro.book_api.model.Loan;
import com.pro.book_api.model.Reader;
import com.pro.book_api.service.BookService;
import com.pro.book_api.service.LoanService;
import com.pro.book_api.service.ReaderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;
    private final BookService bookService;
    private final ReaderService readerService;
    private final LoanMapper loanMapper;

    @PostMapping
    public ResponseEntity<LoanDto> addLoan(@RequestBody @Valid LoanCreateDto loan) {

        Book book = bookService.getBookById(loan.getBookId());
        if(book.getAvailableCopies() == 0) throw new RuntimeException("Книга в данный момент отсутствует");

        Reader reader = readerService.getReaderById(loan.getReaderId());

        Loan createdLoan = loanService.createLoan(book, reader);

        return ResponseEntity.ok(loanMapper.toDto(createdLoan));
    }

    @PostMapping("/{id}/return")
    public ResponseEntity<LoanDto> returnLoan(@PathVariable long id) {

        Loan returnedLoan = loanService.returnLoan(id);

        return ResponseEntity.ok(loanMapper.toDto(returnedLoan));
    }

    @GetMapping
    public ResponseEntity<List<LoanDto>> getAllLoans() {
        return ResponseEntity.ok(
                loanService.getAllLoans()
                        .stream()
                        .map(loanMapper::toDto)
                        .toList()
        );
    }

}
