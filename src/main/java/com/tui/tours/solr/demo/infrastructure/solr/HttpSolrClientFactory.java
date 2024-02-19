package com.tui.tours.solr.demo.infrastructure.solr;

import org.apache.solr.client.solrj.impl.HttpSolrClient;

public interface HttpSolrClientFactory {
    HttpSolrClient create();
}
