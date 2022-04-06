package uppgiftGbara.views;

import uppgiftGbara.service.ReviewService;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;


@Route(value = "/reviews", layout = AppView.class)
public class ReviewView extends VerticalLayout {

    public ReviewView(ReviewService reviewService) {

        add(new H2("Reviews"));

        setAlignItems(Alignment.CENTER);

        reviewService.findAll().forEach(review -> {

            H3 gameTitle = new H3(review.getGameTitle());

            Paragraph reviewText = new Paragraph(review.getReviewText());
            Paragraph reviewPlus = new Paragraph(review.getReviewPlus());
            Paragraph reviewMinus = new Paragraph(review.getReviewMinus());
            Paragraph reviewScore = new Paragraph(String.valueOf(review.getReviewScore()));

            Paragraph writtenBy = new Paragraph("Written by: ");
            Span author = new Span(review.getAuthor());
            author.getStyle().set("font-weight", "bold");
            writtenBy.add(author);

            add(gameTitle, reviewText, reviewPlus, reviewMinus, reviewScore, writtenBy, new Hr());

        });



    }




}