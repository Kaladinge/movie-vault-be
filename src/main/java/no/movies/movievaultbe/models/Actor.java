package no.movies.movievaultbe.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int actor_id;
    @Column(length = 40, nullable = false)
    private String actor_name;
    @Column(length = 60, nullable = false)
    private String actor_description;

    //Relations
    /*
    @ManyToMany(mappedBy = "actors")
    private Set<Movie> movies;

     */
}
