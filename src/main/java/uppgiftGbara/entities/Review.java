package uppgiftGbara.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NotBlank
    private String gameTitle;

    @Column
    private String reviewText;

    @Column
    private String reviewPlus;

    @Column
    private String reviewMinus;

    @Column
    /*@Size(min= 0, max= 5)*/
    private int ReviewScore;

    @Column
    private String author;

    public Review(String gameTitle, String reviewText, String reviewPlus, String reviewMinus, int reviewScore, String author) {
        this.gameTitle = gameTitle;
        this.reviewText = reviewText;
        this.reviewPlus = reviewPlus;
        this.reviewMinus = reviewMinus;
        this.ReviewScore = reviewScore;
        this.author = author;
    }

    public Review() {

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

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public String getReviewPlus() {
        return reviewPlus;
    }

    public void setReviewPlus(String reviewPlus) {
        this.reviewPlus = reviewPlus;
    }

    public String getReviewMinus() {
        return reviewMinus;
    }

    public void setReviewMinus(String reviewMinus) {
        this.reviewMinus = reviewMinus;
    }

    public int getReviewScore() {
        return ReviewScore;
    }

    public void setReviewScore(int reviewScore) {
        ReviewScore = reviewScore;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", gameTitle='" + gameTitle + '\'' +
                ", reviewText='" + reviewText + '\'' +
                ", reviewPlus='" + reviewPlus + '\'' +
                ", reviewMinus='" + reviewMinus + '\'' +
                ", ReviewScore=" + ReviewScore +
                ", author='" + author + '\'' +
                '}';
    }
}