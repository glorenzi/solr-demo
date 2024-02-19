package com.tui.tours.solr.demo.infrastructure.solr;

import com.tui.tours.solr.demo.domain.Tour;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
interface TourDocumentsMapper {
    TourDocument toTourDocument(Tour tour);
    Tour toTour(TourDocument tourDocument);
    List<Tour> toTours(Iterable<TourDocument> tourDocuments);
}
