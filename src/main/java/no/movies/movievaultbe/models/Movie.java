package no.movies.movievaultbe.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movie_id;
    @Column(length = 30, nullable = false)
    private String movie_name;
    @Column(length = 60)
    private String movie_description;
    @Column(nullable = false)
    private int movie_hours;
    @Column(nullable = false)
    private int movie_minutes;
    @Column(nullable = false)
    private int movie_age;

    //Relations
    @ManyToMany
    private Set<Actor> actors;
    @ManyToOne
    @JoinColumn(name = "fran_id")
    private Director franchise;
    @ManyToOne
    @JoinColumn(name = "director_id")
    private Director director;
}
