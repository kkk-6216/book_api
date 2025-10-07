package com.pro.book_api.service;

import com.pro.book_api.model.Book;
import com.pro.book_api.model.Loan;
import com.pro.book_api.model.Reader;
import com.pro.book_api.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LoanService {

    private final LoanRepository loanRepository;

    @Transactional
    public Loan createLoan(Book book, Reader reader) {

        Loan loan = new Loan();
        loan.setBook(book);
        loan.setReader(reader);
        loan.setLoanDate(LocalDate.now());

        book.setAvailableCopies(book.getAvailableCopies() - 1);

        return loanRepository.save(loan);
    }

    @Transactional
    public Loan returnLoan(long id) {
        Loan loan = getLoanById(id);

        Book book = loan.getBook();
        book.setAvailableCopies(book.getAvailableCopies() + 1);

        loan.setReturnDate(LocalDate.now());
        return loanRepository.save(loan);
    }

    public Loan getLoanById(long id) {
        return loanRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Не найдена выдача с id " + id)
        );
    }

    public List<Loan> getAllLoans () {
        return loanRepository.findAll();
    }
}
