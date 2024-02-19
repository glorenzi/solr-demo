package com.tui.tours.solr.demo.infrastructure.solr;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.util.List;

@Getter
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@SolrDocument(collection = "tours")
public class TourDocument {
    @Id
    String id;
    @Field("name_t")
    String name;
    @Field("description_t")
    String description;
    @Field("destination_t")
    String destination;
    @Field("tags_ss")
    List<String> tags;
    @Field("price_d")
    double price;
}
