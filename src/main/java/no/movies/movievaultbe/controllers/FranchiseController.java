package no.movies.movievaultbe.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import no.movies.movievaultbe.models.Franchise;
import no.movies.movievaultbe.repositories.FranchiseRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(value = "api/v1/franchises")
public class FranchiseController {

    private final FranchiseRepository franchiseRepository;

    public FranchiseController(FranchiseRepository franchiseRepository) {
        this.franchiseRepository = franchiseRepository;
    }

    @Operation(summary = "Get all franchises")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = @Content)
    })
    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(franchiseRepository.findAll());
    }

    @Operation(summary = "Get franchise by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = @Content),
            @ApiResponse(responseCode = "404",
                    description = "Failed to fetch franchise by ID",
                    content = @Content)
    })
    @GetMapping("{id}")
    public ResponseEntity findOne(@PathVariable int id) {
        return ResponseEntity.ok(franchiseRepository.findById(id));
    }

    @Operation(summary = "Add new franchise")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = @Content),
            @ApiResponse(responseCode = "404",
                    description = "Failed to add new franchise",
                    content = @Content)
    })
    @PostMapping
    public ResponseEntity add(@RequestBody Franchise franchise) {
        Franchise fran = franchiseRepository.save(franchise);
        URI location = URI.create("franchises/" + fran.getFran_id());
        return ResponseEntity.created(location).build();
    }

    @Operation(summary = "Update existing franchise")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = @Content),
            @ApiResponse(responseCode = "404",
                    description = "Failed to update existing franchise",
                    content = @Content)
    })
    @PutMapping("{id}")
    public ResponseEntity update(@RequestBody Franchise franchise, @PathVariable int id) {
        if (id != franchise.getFran_id())
            return ResponseEntity.badRequest().build();
        franchiseRepository.save(franchise);
        return ResponseEntity.noContent().build();
    }
}
