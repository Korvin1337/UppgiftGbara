package com.example.uppgiftgbara.views;

import com.example.uppgiftgbara.components.ReviewForm;
import com.example.uppgiftgbara.entities.Review;
import com.example.uppgiftgbara.service.ReviewService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "/managereviews", layout = AppView.class)
public class ManageReviewsView extends VerticalLayout {

    Grid<Review> grid = new Grid<>(Review.class);
    ReviewService reviewService;
    ReviewForm reviewForm;
    /*PrincipalUtil principalUtil;*/

    public ManageReviewsView(ReviewService reviewService) {
        this.reviewService = reviewService;
        this.reviewForm = new ReviewForm(reviewService, this);
        setAlignItems(Alignment.CENTER);
        add(new H2("Coming soon......"));

        grid.setItems(reviewService.findAll());
        grid.removeAllColumns();
        grid.setWidthFull();


        grid.addComponentColumn(review -> {
            Button button = new Button(new Icon(VaadinIcon.AIRPLANE), evt -> {
                Notification.show(review.getGameTitle());
                reviewService.deleteById(review.getId());
                updateItems();
            });

            button.addThemeVariants(
                    ButtonVariant.LUMO_ERROR,
                    ButtonVariant.LUMO_PRIMARY,
                    ButtonVariant.LUMO_SMALL
            );

            return button;
        });

        grid.addColumn(Review::getId).setHeader("Id").setSortable(true).setResizable(true);
        grid.addColumn(Review::getGameTitle).setHeader("Title");
        grid.addColumn(Review::getReviewText).setHeader("Text");
        grid.addColumn(Review::getReviewPlus).setHeader("Plus");
        grid.addColumn(Review::getReviewMinus).setHeader("Minus");
        grid.addColumn(Review::getReviewScore).setHeader("Score");
        grid.addColumn(Review::getAuthor).setHeader("Author");
        grid.asSingleSelect().addValueChangeListener(evt -> {
            reviewForm.setReview(evt.getValue());
        });

        HorizontalLayout mainContent = new HorizontalLayout(grid, reviewForm);
        mainContent.setSizeFull();

        Button button = new Button("Add new review", evt -> {
            Dialog dialog = new Dialog();
            ReviewForm dialogForm = new ReviewForm(reviewService, this);

            Review review = new Review();
            review.setAuthor(review.getAuthor()/*principalUtil.getLoggedInAppUser()*/);

            dialogForm.setReview(review);
            dialog.add(dialogForm);
            dialog.open();
        });

        add(mainContent, button);

    }


    public void updateItems() {
        grid.setItems(reviewService.findAll());
        /*grid.setItems(reviewService.findByUsername(PrincipalUtil.getName()));*/
    }
}
