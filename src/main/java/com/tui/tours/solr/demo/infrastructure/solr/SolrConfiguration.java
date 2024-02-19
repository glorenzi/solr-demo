package com.tui.tours.solr.demo.infrastructure.solr;

import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@Configuration
@EnableSolrRepositories(basePackages = "com.tui.tours.solr.demo.infrastructure.solr")
public class SolrConfiguration {

    @Bean
    HttpSolrClientFactory httpSolrClientFactory(@Value("${spring.data.solr.host}") String solrHost) {
        return () -> new HttpSolrClient.Builder("http://localhost:8983/solr").build();
    }
}
