package com.pro.book_api.controller;

import com.pro.book_api.dto.ReaderCreateDto;
import com.pro.book_api.dto.ReaderDto;
import com.pro.book_api.mapper.ReaderMapper;
import com.pro.book_api.model.Reader;
import com.pro.book_api.service.ReaderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/readers")
@RequiredArgsConstructor
public class ReaderController {

    private final ReaderService readerService;
    private final ReaderMapper readerMapper;

    @PostMapping
    public ResponseEntity<ReaderDto> createReader(@RequestBody @Valid ReaderCreateDto reader) {

        Reader createdReader = readerService.create(readerMapper.toEntity(reader));

        return ResponseEntity.ok(readerMapper.toDto(createdReader));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReaderDto> getReaderById(@PathVariable Long id, java.io.Reader reader) {
        return ResponseEntity.ok(readerMapper.toDto(readerService.getReaderById(id)));
    }

    @GetMapping
    public ResponseEntity<List<ReaderDto>> getAllReaders() {
        return ResponseEntity.ok(readerService.getAllReaders().stream()
                .map(readerMapper::toDto)
                .toList()
        );
    }

}
