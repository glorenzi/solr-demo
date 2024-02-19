package com.tui.tours.solr.demo.infrastructure.solr;

import com.tui.tours.solr.demo.domain.Tour;
import com.tui.tours.solr.demo.domain.ToursRepository;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public class SolrToursRepositoryAdapter implements ToursRepository {
    SolrToursDAO solrToursDAO;
    TourDocumentsMapper tourDocumentsMapper;

    @Override
    public List<Tour> findAll() {
        return tourDocumentsMapper.toTours(solrToursDAO.findAll());
    }

    @Override
    public Tour save(Tour tour) {
        return tourDocumentsMapper.toTour(solrToursDAO.save(tourDocumentsMapper.toTourDocument(tour)));
    }
}
