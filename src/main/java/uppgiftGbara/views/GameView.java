package uppgiftGbara.views;

import uppgiftGbara.service.GameService;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;


@Route(value = "/", layout = AppView.class)
public class GameView extends VerticalLayout {

    public GameView(GameService gameService) {

        add(new H2("Games"));

        setAlignItems(Alignment.CENTER);

        gameService.findAll().forEach(game -> {

            H2 gameTitle = new H2(game.getGameTitle());
            H4 gameDeveloper = new H4(game.getGameDeveloper());
            H4 gameReleaseYear = new H4(String.valueOf(game.getReleaseYear()));

            add(gameTitle, gameDeveloper, gameReleaseYear, new Hr());


        });


    }


}
