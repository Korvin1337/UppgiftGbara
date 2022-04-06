package uppgiftGbara.service;

import uppgiftGbara.entities.Review;
import uppgiftGbara.repositorys.ReviewRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    /*public List<Review> findByUsername(String username) {
        return "";/*reviewRepository.findByAppUser_Username(username);
    }*/

    public Review findReviewById(int id) {
        return reviewRepository.findById(id).orElseThrow();
    }

    public void deleteById(int id) {
        reviewRepository.deleteById(id);
    }

    public Review save(Review review) {
        return reviewRepository.save(review);
    }

    public Review updateById(int id, Review changedReview) {

        Review existingReview = reviewRepository.findById(id).orElseThrow();


        if(changedReview.getGameTitle() .length() > 0
                && changedReview.getReviewText().length() > 0
                && changedReview.getReviewPlus() .length() > 0
                && changedReview.getReviewMinus() .length() > 0
                && changedReview.getReviewScore() >= 0 && changedReview.getReviewScore() <= 5
                && changedReview.getAuthor().length() > 0)
        {
            BeanUtils.copyProperties(changedReview, existingReview, "id");
        }

        reviewRepository.save(existingReview);

        return existingReview;

    }


}
