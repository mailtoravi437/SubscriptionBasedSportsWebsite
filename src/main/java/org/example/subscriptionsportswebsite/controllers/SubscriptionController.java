package org.example.subscriptionsportswebsite.controllers;

import org.example.subscriptionsportswebsite.Models.Subscription;
import org.example.subscriptionsportswebsite.services.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {
    @Autowired
    private SubscriptionService subscriptionService;

    @PostMapping
    public ResponseEntity<Subscription> createSubscription(@RequestBody Subscription subscription) {
        Subscription createdSubscription = subscriptionService.createSubscription(subscription);
        return new ResponseEntity<>(createdSubscription, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Subscription> getSubscriptionByUserId(@PathVariable Long userId) {
        Optional<Subscription> subscription = subscriptionService.getSubscriptionByUserId(userId);
        if(subscription.isPresent()){
            if(LocalDate.now().isAfter(subscription.get().getExpiryDate())){
                subscriptionService.cancelSubscription(userId);
                return new ResponseEntity<>(HttpStatus.GONE);
            }
            else{
                return new ResponseEntity<>(subscription.get(), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> cancelSubscription(@PathVariable Long userId) {
        subscriptionService.cancelSubscription(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}