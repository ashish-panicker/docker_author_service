package com.ust.docker_author_service.controller;

import com.ust.docker_author_service.domain.Author;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private List<Author> authors = new ArrayList<>();

    // GET /authors
    @GetMapping
    public ResponseEntity<List<Author>> getAuthors() {
        return ResponseEntity.ok(authors);
    }
    // GET /authors/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthor(@PathVariable int id) {
        var res = authors.stream().filter(author -> author.getId() == id).findFirst().orElse(null);
        return res == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(res);
    }

    // POST /authors
    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        authors.add(author);
        return ResponseEntity.ok(author);
    }

}
