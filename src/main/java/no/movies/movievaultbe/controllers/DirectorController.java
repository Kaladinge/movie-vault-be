package no.movies.movievaultbe.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import no.movies.movievaultbe.models.Director;
import no.movies.movievaultbe.repositories.DirectorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(value = "api/v1/directors")
public class DirectorController {

    private final DirectorRepository directorRepository;

    public DirectorController(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    @Operation(summary = "Get all directors")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                description = "Success",
                content = @Content)
    })
    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(directorRepository.findAll());
    }

    @Operation(summary = "Get director by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = @Content),
            @ApiResponse(responseCode = "404",
                    description = "Failed to fetch director by ID",
                    content = @Content)
    })
    @GetMapping("{id}")
    public ResponseEntity findOne(@PathVariable int id) {
        return ResponseEntity.ok(directorRepository.findById(id));
    }


    @Operation(summary = "Add new director")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = @Content),
            @ApiResponse(responseCode = "404",
                    description = "Failed to add new director",
                    content = @Content)
    })
    @PostMapping
    public ResponseEntity add(@RequestBody Director director) {
        Director direc = directorRepository.save(director);
        URI location = URI.create("directors/" + direc.getDirector_id());
        return ResponseEntity.created(location).build();
    }

    @Operation(summary = "Update existing director")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = @Content),
            @ApiResponse(responseCode = "404",
                    description = "Failed to update existing director",
                    content = @Content)
    })
    @PutMapping("{id}")
    public ResponseEntity update(@RequestBody Director director, @PathVariable int id) {
        if (id != director.getDirector_id())
            return ResponseEntity.badRequest().build();
        directorRepository.save(director);
        return ResponseEntity.noContent().build();
    }
}
