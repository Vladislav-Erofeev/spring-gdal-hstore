package com.example.demoscriptspring.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class LineDTO {
    private long id;
    private String highway;
    private String name;
    private Map<String, String> properties;
}
