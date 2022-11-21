package no.movies.movievaultbe.controllers;

import no.movies.movievaultbe.repositories.DirectorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/directors")
public class DirectorController {

    private final DirectorRepository directorRepository;

    public DirectorController(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(directorRepository.findAll());
    }
}
