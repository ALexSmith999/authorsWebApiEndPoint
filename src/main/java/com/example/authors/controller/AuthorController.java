package com.example.authors.controller;

import com.example.authors.dto.AuthorNameDto;
import com.example.authors.entity.Author;
import com.example.authors.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService service;

    public AuthorController(AuthorService service) {
        this.service = service;
    }

    // ✅ Returns only author names
    @GetMapping
    public List<AuthorNameDto> getAllAuthorNames() {
        return service.getAuthorNames();
    }

    // ✅ Returns full author info
    @GetMapping("/{name}")
    public Author getAuthorByName(@PathVariable String name) {
        return service.getAuthorByName(name);
    }
}
