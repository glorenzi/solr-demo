package com.tui.tours.solr.demo.domain;

import java.util.List;

public interface ToursRepository {
    List<Tour> findAll();
    Tour save(Tour tour);
}
