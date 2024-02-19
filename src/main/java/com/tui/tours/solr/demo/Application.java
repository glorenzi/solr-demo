package com.tui.tours.solr.demo;

import com.tui.tours.solr.demo.domain.Tour;
import com.tui.tours.solr.demo.domain.ToursRepository;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Random;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
@Order(100)
public class Application implements ApplicationRunner {
    ToursRepository toursRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Random random = new Random();

        String[] tags = {"tag1", "tag2", "tag3", "tag4", "tag5", "tag6"};

        for (int i = 0; i < 10; i++) {
            String id = String.valueOf(random.nextInt(1000));
            String name = "Tour " + random.nextInt(1000);
            String description = "Description " + random.nextInt(1000);
            String destination = "Destination " + random.nextInt(1000);
            double price = 100 + (500 - 100) * random.nextDouble();

            // Generate two random indices to select two tags from the array
            int tagIndex1 = random.nextInt(tags.length);
            int tagIndex2;
            do {
                tagIndex2 = random.nextInt(tags.length);
            } while (tagIndex1 == tagIndex2); // Ensure we get two different tags

            Tour tour = Tour.builder()
                    .id(id)
                    .name(name)
                    .description(description)
                    .destination(destination)
                    .price(price)
                    .tags(Arrays.asList(tags[tagIndex1], tags[tagIndex2])) // Assign the selected tags to the Tour object
                    .build();

            toursRepository.save(tour);
        }
        System.out.println(toursRepository.findAll());
    }
}
