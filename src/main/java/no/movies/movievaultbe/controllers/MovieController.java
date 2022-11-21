package no.movies.movievaultbe.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1")
public class MovieController {

    @GetMapping("welcome")
    public ResponseEntity welcome() {
        return ResponseEntity.ok("Hi");
    }

    @GetMapping("present/{name}")
    public ResponseEntity present(@PathVariable String name) {
        return ResponseEntity.ok("Hello " + name);
    }

    @GetMapping("present2")
    public ResponseEntity present2(@RequestParam String name) {
        return ResponseEntity.ok("Hello " + name);
    }
}
