package com.example.demoscriptspring.controllers;

import com.example.demoscriptspring.domain.dto.LineDTO;
import com.example.demoscriptspring.domain.entities.Line;
import com.example.demoscriptspring.services.LineService;
import com.example.demoscriptspring.services.mapper.LineMapper;
import lombok.RequiredArgsConstructor;
import org.postgresql.util.HStoreConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MainController {
    private final LineService lineService;
    private final LineMapper lineMapper = LineMapper.INSTANCE;

    @GetMapping("/layer/{layername}")
    public List<LineDTO> get(@PathVariable("layername") String layername,
                             @RequestParam(name = "page", defaultValue = "0", required = false) int page,
                             @RequestParam(name = "limit", defaultValue = "20", required = false) int limit) {

        return lineService.getLinesByLayername(layername, page, limit)
                .stream().map(this::convertToLineDTO).collect(Collectors.toList());
    }

    private LineDTO convertToLineDTO(Line line) {
        LineDTO lineDTO = lineMapper.convertToLineDTO(line);
        if (line.getProps() != null)
            lineDTO.setProperties(HStoreConverter.fromString(line.getProps()));
        return lineDTO;
    }
}
