package org.example.subscriptionsportswebsite.services;

import lombok.NonNull;
import org.example.subscriptionsportswebsite.Models.Score;
import org.example.subscriptionsportswebsite.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ScoreServices {
    @Autowired
    ScoreRepository scoreRepository;

    public Optional<Score> getScoreByGameId(@NonNull Long id) {
        return scoreRepository.findById(id);
    }

    public Optional<Score> updateScoreByGameId(@NonNull Long id, @NonNull Score score) {
        return Optional.of(scoreRepository.save(score));
    }
}
