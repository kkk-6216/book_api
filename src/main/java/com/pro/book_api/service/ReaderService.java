package com.pro.book_api.service;

import com.pro.book_api.handler.exception.ResourceAlreadyExistsException;
import com.pro.book_api.model.Reader;
import com.pro.book_api.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReaderService {

    private final ReaderRepository readerRepository;

    @Transactional
    public Reader create(Reader entity) {
        if (readerRepository.existsByEmail(entity.getEmail())) throw new ResourceAlreadyExistsException("Читатель с почтой " + entity.getEmail() + " уже существует");
        return readerRepository.save(entity);
    }

    public Reader getReaderById(Long id) {
        return readerRepository.findById(id).orElseThrow(() -> new RuntimeException("Читатель не найдена с id " + id));
    }

    public List<Reader> getAllReaders() {
        return readerRepository.findAll();
    }
}
