package com.pro.book_api.mapper;

import com.pro.book_api.dto.ReaderCreateDto;
import com.pro.book_api.dto.ReaderDto;
import com.pro.book_api.model.Reader;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ReaderMapper {

    public Reader toEntity(ReaderCreateDto dto) {
        Reader reader = new Reader();
        reader.setName(dto.getName());
        reader.setEmail(dto.getEmail());
        reader.setRegisteredAt(LocalDateTime.now());
        return reader;
    }

    public ReaderDto toDto(Reader createdReader) {
        ReaderDto readerDto = new ReaderDto();
        readerDto.setId(createdReader.getId());
        readerDto.setName(createdReader.getName());
        readerDto.setEmail(createdReader.getEmail());
        readerDto.setRegisteredAt(createdReader.getRegisteredAt());
        return readerDto;
    }
}
