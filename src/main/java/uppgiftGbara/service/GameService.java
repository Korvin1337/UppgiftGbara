package uppgiftGbara.service;

import uppgiftGbara.entities.Game;
import uppgiftGbara.repositorys.GameRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    public List<Game> findByGameTitle(String gameTitle) {
        return gameRepository.findByGameTitle(gameTitle);
    }

    public Game findGameById(int id) {
        return gameRepository.findById(id).orElseThrow();
    }

    public void deleteById(int id) {
        gameRepository.deleteById(id);
    }

    public Game save(Game game) {
        return gameRepository.save(game);
    }

    public Game updateById(int id, Game changedGame) {

        Game existingGame = gameRepository.findById(id).orElseThrow();

        if(changedGame.getGameTitle() != null && changedGame.getGameDeveloper() != null && changedGame.getReleaseYear() > 0 && changedGame.getReleaseYear() < 2050) {
            BeanUtils.copyProperties(changedGame, existingGame, "id");
        }

        gameRepository.save(existingGame);

        return existingGame;
    }


}
