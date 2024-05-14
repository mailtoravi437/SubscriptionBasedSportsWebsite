package org.example.subscriptionsportswebsite.services;

import org.example.subscriptionsportswebsite.Models.Game;
import org.example.subscriptionsportswebsite.Models.GameStatus;
import org.example.subscriptionsportswebsite.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;
    public Game createGame(Game game) {
        return gameRepository.save(game);
    }

    public Optional<Game> getGameById(Long id) {
        return gameRepository.findById(id);
    }

    public Optional<Game> updateGame(Game game) {
        return Optional.of(gameRepository.save(game));
    }

    public void deleteGame(Long id) {
        gameRepository.deleteById(id);
    }

    public Iterable<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Iterable<Game> getGamesByStatus(String status) {
        return gameRepository.findByStatus(status);
    }

    public GameStatus getStatusById(Long id) {
        return gameRepository.findById(id).get().getStatus();
    }
}
