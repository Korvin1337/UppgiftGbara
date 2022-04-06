package uppgiftGbara.components;

import uppgiftGbara.entities.Review;
import uppgiftGbara.service.ReviewService;
import uppgiftGbara.views.ManageReviewsView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;

public class GameForm extends FormLayout {

    TextField gameTitle = new TextField("gameTitle");
    TextArea reviewText = new TextArea("reviewText");
    TextField reviewPlus = new TextField("reviewPlus");
    TextField reviewMinus = new TextField("reviewMinus");
    IntegerField reviewScore = new IntegerField("reviewScore");
    TextField author = new TextField("author");
    Button saveButton = new Button("Save");
    /*this.appUser = appUser;*/

    Binder<Review> binder = new BeanValidationBinder<>(Review.class);
    ReviewService reviewService;
    ManageReviewsView manageReviewView;

    public GameForm(ReviewService reviewService, ManageReviewsView manageReviewView) {
        this.reviewService = reviewService;
        this.manageReviewView = manageReviewView;
        binder.bindInstanceFields(this);
        setVisible(false);

        saveButton.addClickListener(evt -> handleSave(manageReviewView));

        add(gameTitle, reviewText, reviewPlus, reviewMinus, reviewScore, author, saveButton);
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