package com.example.uppgiftgbara;

import com.example.uppgiftgbara.entities.Review;
import com.example.uppgiftgbara.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class UppgiftGbaraApplication {

    @Autowired
    ReviewRepository reviewRepository;

    public static void main(String[] args) {
        SpringApplication.run(UppgiftGbaraApplication.class, args);
    }

    @Bean
    CommandLineRunner init(ReviewRepository reviewRepository) {
        return args -> {

            Review fifa22 = new Review("FIFA 22", "Jag gillar ej fifa", "Inget", "Allt", 0, "Kevin");
            Review eldenRing = new Review("Elden Ring", "Jag gillar elden ring", "Allt", "Inget", 4, "Kevin");
            /*reviewRepository.saveAll(List.of(fifa22, eldenRing));*/

        };
    }

}
