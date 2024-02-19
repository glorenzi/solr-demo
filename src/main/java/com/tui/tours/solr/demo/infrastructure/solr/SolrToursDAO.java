package com.tui.tours.solr.demo.infrastructure.solr;

import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolrToursDAO extends SolrCrudRepository<TourDocument, String> {
}
