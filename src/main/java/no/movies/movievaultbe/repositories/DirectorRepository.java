package no.movies.movievaultbe.repositories;

import no.movies.movievaultbe.models.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository (DAO) for the Director domain class.
 */
@Repository
public interface DirectorRepository extends JpaRepository<Director,Integer> {
}
