package com.pro.book_api.repository;

import com.pro.book_api.model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long> {
    boolean existsByEmail(String email);
}