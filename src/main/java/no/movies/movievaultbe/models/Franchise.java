package no.movies.movievaultbe.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Franchise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fran_id;
    @Column(length = 40, nullable = false)
    private String fran_name;
    @Column(length = 60)
    private String fran_description;

    //Relations
    @OneToMany(mappedBy = "franchise")
    private Set<Movie> movies;
}
