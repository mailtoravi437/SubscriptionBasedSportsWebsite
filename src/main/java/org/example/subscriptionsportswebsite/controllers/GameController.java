package org.example.subscriptionsportswebsite.controllers;

import org.example.subscriptionsportswebsite.Models.Game;
import org.example.subscriptionsportswebsite.Models.GameStatus;
import org.example.subscriptionsportswebsite.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/games")
public class GameController {
    @Autowired
    private GameService gameService;

    @PostMapping
    public ResponseEntity<Game> createGame(@RequestBody Game game) {
        Game createdGame = gameService.createGame(game);
        return new ResponseEntity<>(createdGame, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable Long id) {
        Optional<Game> game = gameService.getGameById(id);
        return game.isPresent() ? new ResponseEntity<>(game.get(), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Game> updateGame(@PathVariable Long id, @RequestBody Game game) {
        game.setId(id);
        Optional<Game> updatedGame = gameService.updateGame(game);
        return updatedGame.isPresent() ? new ResponseEntity<>(updatedGame.get(), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable Long id) {
        gameService.deleteGame(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<Game>> getAllGames() {
        Iterable<Game> games = gameService.getAllGames();
        return new ResponseEntity<>(games, HttpStatus.OK);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<Iterable<Game>> getGamesByStatus(@PathVariable String status) {
        Iterable<Game> games = gameService.getGamesByStatus(status);
        return new ResponseEntity<>(games, HttpStatus.OK);
    }

    @GetMapping("/status/{id}")
    public ResponseEntity<GameStatus> getStatusById(@PathVariable Long id) {
        GameStatus status = gameService.getStatusById(id);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

}
