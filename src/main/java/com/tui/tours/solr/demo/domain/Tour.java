package com.tui.tours.solr.demo.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Tour {
    @EqualsAndHashCode.Include
    String id;
    String name;
    String description;
    String destination;
    List<String> tags;
    double price;
}
