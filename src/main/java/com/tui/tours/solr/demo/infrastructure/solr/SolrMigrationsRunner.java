package com.tui.tours.solr.demo.infrastructure.solr;

import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.request.CoreAdminRequest;
import org.apache.solr.client.solrj.response.CoreAdminResponse;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

//@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
@Order(1)
public class SolrMigrationsRunner implements ApplicationRunner {
    HttpSolrClientFactory httpSolrClientFactory;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try (HttpSolrClient httpSolrClient = httpSolrClientFactory.create()) {
            CoreAdminRequest.Create createRequest = new CoreAdminRequest.Create();
            createRequest.setCoreName("tours");
            createRequest.setConfigSet("_default");
            createRequest.setInstanceDir("tours");

            CoreAdminResponse createResponse = createRequest.process(httpSolrClient);
            if (createResponse.getStatus() == 0) {
                System.out.println("Core created successfully");
            } else {
                throw new RuntimeException("Error creating core: " + createResponse.getResponse().get("error"));
            }
        }
    }
}
