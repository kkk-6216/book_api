package com.pro.book_api.mapper;

import com.pro.book_api.dto.LoanDto;
import com.pro.book_api.model.Loan;
import org.springframework.stereotype.Component;

@Component
public class LoanMapper {

    public LoanDto toDto(Loan createdLoan) {
        LoanDto loanDto = new LoanDto();
        loanDto.setId(createdLoan.getId());
        loanDto.setBookId(createdLoan.getBook().getId());
        loanDto.setReaderId(createdLoan.getReader().getId());
        loanDto.setLoanDate(createdLoan.getLoanDate());
        loanDto.setReturnDate(createdLoan.getReturnDate());
        return loanDto;
    }

}
