package org.example.subscriptionsportswebsite.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private GameStatus status;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Team> teams;
    private Date dateTime;
    private String location;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Score> scores;

}
