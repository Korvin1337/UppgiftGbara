package uppgiftGbara;

import uppgiftGbara.entities.AppUser;
import uppgiftGbara.entities.Game;
import uppgiftGbara.entities.Review;
import uppgiftGbara.repositorys.AppUserRepository;
import uppgiftGbara.repositorys.GameRepository;
import uppgiftGbara.repositorys.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class UppgiftGbaraApplication {

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    GameRepository gameRepository;

    @Autowired
    ReviewRepository reviewRepository;

    public static void main(String[] args) {
        SpringApplication.run(UppgiftGbaraApplication.class, args);
    }


    @Bean
    CommandLineRunner init(AppUserRepository appUserRepository, GameRepository gameRepository, ReviewRepository reviewRepository) {
        return args -> {

            AppUser Gunnar = new AppUser("Gunnar");
            AppUser Alice = new AppUser("Alice");
            appUserRepository.saveAll(List.of(Gunnar, Alice));

            Game fifa22 = new Game("FIFA 22", "EA", 2021);
            Game eldenRing = new Game("Elden Ring", "Japanese", 2022);
            gameRepository.saveAll(List.of(fifa22, eldenRing));

            Review fifa22Review = new Review("Fifa Suger", "Gillar Inte Fifa", "Inget", "Allt", 0, Gunnar.getUsername());
            Review eldenRingReview = new Review("Elden Ring Bra", "Gillar Elden Ring", "Allt", "Inget", 4, Alice.getUsername());
            reviewRepository.saveAll(List.of(fifa22Review, eldenRingReview));


        };
    }
}
