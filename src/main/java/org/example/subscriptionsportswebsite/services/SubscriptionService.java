package org.example.subscriptionsportswebsite.services;

import org.example.subscriptionsportswebsite.Models.Subscription;
import org.example.subscriptionsportswebsite.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Optional;

@Service
public class SubscriptionService {
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public Subscription createSubscription(Subscription subscription) {
        subscription.setActivationDate(LocalDate.now());
        subscription.setExpiryDate(LocalDate.now().plusYears(1));
        return subscriptionRepository.save(subscription);
    }

    public Optional<Subscription> getSubscriptionByUserId(Long userId) {
        return subscriptionRepository.findById(userId);
    }

    public void cancelSubscription(Long userId) {
        subscriptionRepository.deleteById(userId);
    }

}