package com.example.demoscriptspring.services.mapper;

import com.example.demoscriptspring.domain.dto.LineDTO;
import com.example.demoscriptspring.domain.entities.Line;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LineMapper {
    LineMapper INSTANCE = Mappers.getMapper(LineMapper.class);

    @Mapping(target = "properties", ignore = true)
    LineDTO convertToLineDTO(Line line);
}
