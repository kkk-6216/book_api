package com.pro.book_api.controller;

import com.pro.book_api.dto.ReaderCreateDto;
import com.pro.book_api.dto.ReaderDto;
import com.pro.book_api.mapper.ReaderMapper;
import com.pro.book_api.model.Reader;
import com.pro.book_api.service.ReaderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/readers")
@RequiredArgsConstructor
@Tag(name = "Читатели", description = "Endpoint-ы для читателям библиотеки")
public class ReaderController {

    private final ReaderService readerService;
    private final ReaderMapper readerMapper;

    @PostMapping
    @Operation(summary = "Создать нового читателя")
    public ResponseEntity<ReaderDto> createReader(@RequestBody @Valid ReaderCreateDto reader) {

        Reader createdReader = readerService.create(readerMapper.toEntity(reader));

        return ResponseEntity.ok(readerMapper.toDto(createdReader));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить читателя по ID")
    public ResponseEntity<ReaderDto> getReaderById(@PathVariable Long id, java.io.Reader reader) {
        return ResponseEntity.ok(readerMapper.toDto(readerService.getReaderById(id)));
    }

    @GetMapping
    @Operation(summary = "Получить список всех читателей")
    public ResponseEntity<List<ReaderDto>> getAllReaders() {
        return ResponseEntity.ok(readerService.getAllReaders().stream()
                .map(readerMapper::toDto)
                .toList()
        );
    }

}
