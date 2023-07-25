package com.example.demoscriptspring.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "lines")
public class Line {
    @GeneratedValue
    @Id
    @Column(name = "_id")
    private long id;

    @Column(name = "highway")
    private String highway;

    @Column(name = "name")
    private String name;

    @Column(name = "other_tags")
    private String props;
}
