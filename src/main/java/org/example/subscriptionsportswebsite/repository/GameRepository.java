package org.example.subscriptionsportswebsite.repository;

import org.example.subscriptionsportswebsite.Models.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
    Iterable<Game> findByStatus(String status);
}
