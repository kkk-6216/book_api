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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
@RequiredArgsConstructor
@Tag(name = "Выдачи", description = "Endpoint-ы для выдачам книг")
public class LoanController {

    private final LoanService loanService;
    private final BookService bookService;
    private final ReaderService readerService;
    private final LoanMapper loanMapper;

    @PostMapping
    @Operation(summary = "Создать выдачу книги")
    public ResponseEntity<LoanDto> addLoan(@RequestBody @Valid LoanCreateDto loan) {

        Book book = bookService.getBookById(loan.getBookId());
        if(book.getAvailableCopies() == 0) throw new RuntimeException("Книга в данный момент отсутствует");

        Reader reader = readerService.getReaderById(loan.getReaderId());

        Loan createdLoan = loanService.createLoan(book, reader);

        return ResponseEntity.ok(loanMapper.toDto(createdLoan));
    }

    @PostMapping("/{id}/return")
    @Operation(summary = "Вернуть книгу по выдаче")
    public ResponseEntity<LoanDto> returnLoan(@PathVariable long id) {

        Loan returnedLoan = loanService.returnLoan(id);

        return ResponseEntity.ok(loanMapper.toDto(returnedLoan));
    }

    @GetMapping
    @Operation(summary = "Получить список всех выдач")
    public ResponseEntity<List<LoanDto>> getAllLoans() {
        return ResponseEntity.ok(
                loanService.getAllLoans()
                        .stream()
                        .map(loanMapper::toDto)
                        .toList()
        );
    }

}
