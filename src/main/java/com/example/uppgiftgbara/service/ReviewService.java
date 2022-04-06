package com.example.uppgiftgbara.service;


import com.example.uppgiftgbara.entities.Review;
import com.example.uppgiftgbara.repositories.ReviewRepository;
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


        if(changedReview.getGameTitle() != null
                && changedReview.getReviewText() != null
                && changedReview.getReviewPlus() != null
                && changedReview.getReviewMinus() != null
                && changedReview.getReviewScore() >= 0 && changedReview.getReviewScore() <= 5)
        {
            BeanUtils.copyProperties(changedReview, existingReview, "id");
        }

        reviewRepository.save(existingReview);

        return existingReview;

    }


}
