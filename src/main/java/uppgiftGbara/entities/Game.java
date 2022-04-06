package uppgiftGbara.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NotBlank
    private String gameTitle;

    @Column
    private String gameDeveloper;

    @Column
    private int releaseYear;

    public Game(String gameTitle, String gameDeveloper, int releaseYear) {
        this.gameTitle = gameTitle;
        this.gameDeveloper = gameDeveloper;
        this.releaseYear = releaseYear;
    }

    public Game() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public String getGameDeveloper() {
        return gameDeveloper;
    }

    public void setGameDeveloper(String gameDeveloper) {
        this.gameDeveloper = gameDeveloper;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", gameTitle='" + gameTitle + '\'' +
                ", gameDeveloper='" + gameDeveloper + '\'' +
                ", releaseYear=" + releaseYear +
                '}';
    }
}
