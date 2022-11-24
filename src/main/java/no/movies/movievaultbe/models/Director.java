package no.movies.movievaultbe.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter

public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int director_id;
    @Column(length = 30, nullable = false)
    private String director_name;

    //Relations
    /*
    @OneToMany(mappedBy = "director")
    private Set<Movie> movies;

     */
}
