package com.example.uppgiftgbara.components;

import com.example.uppgiftgbara.entities.Review;
import com.example.uppgiftgbara.service.ReviewService;
import com.example.uppgiftgbara.views.ManageReviewsView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;

public class ReviewForm extends FormLayout {

    TextField reviewTitle = new TextField("reviewTitle");
    TextArea reviewText = new TextArea("reviewText");
    TextField reviewPlus = new TextField("reviewPlus");
    TextField reviewMinus = new TextField("reviewMinus");
    TextField reviewScore = new TextField("reviewScore");
    Button saveButton = new Button("Save");
    /*this.appUser = appUser;*/

    Binder<Review> binder = new BeanValidationBinder<>(Review.class);
    ReviewService reviewService;
    ManageReviewsView manageReviewView;

    public ReviewForm(ReviewService reviewService, ManageReviewsView manageReviewView) {
        this.reviewService = reviewService;
        this.manageReviewView = manageReviewView;
        binder.bindInstanceFields(this);
        setVisible(false);

        saveButton.addClickListener(evt -> handleSave(manageReviewView));

        add(reviewTitle, reviewText, reviewPlus, reviewMinus, reviewScore, saveButton);
    }

    private void handleSave(ManageReviewsView manageReviewsView) {
        Review review = binder.validate().getBinder().getBean();
        if(review.getId() == 0) {
            reviewService.save(review);
        }
        reviewService.updateById(review.getId(), review);
        setReview(null);
        manageReviewsView.updateItems();

        this.getParent().ifPresent(component -> {
            if(component instanceof Dialog) {
                ((Dialog) component).close();
            }
        });
    }

    public void setReview(Review review) {
        setVisible(false);
        if(review != null) {
            binder.setBean(review);
            setVisible(true);
        }
    }

}
