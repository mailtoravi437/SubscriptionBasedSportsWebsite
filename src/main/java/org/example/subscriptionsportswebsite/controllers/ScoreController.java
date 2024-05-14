package org.example.subscriptionsportswebsite.controllers;

import org.example.subscriptionsportswebsite.Models.Score;
import org.example.subscriptionsportswebsite.services.ScoreServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/scores")
public class ScoreController {
    @Autowired
    ScoreServices scoreServices;

    @GetMapping("{gameId}")
    public Optional<Score> getScoreByGameId(Long id) {
        return scoreServices.getScoreByGameId(id);
    }

    @PutMapping("{gameId}")
    public Optional<Score> updateScoreByGameId(Long id, Score score) {
        return scoreServices.updateScoreByGameId(id, score);
    }


}
