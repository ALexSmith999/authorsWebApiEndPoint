package com.example.authors.controller;

import com.example.authors.dto.AuthorNameDto;
import com.example.authors.entity.Author;
import com.example.authors.service.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private static final Logger logger = LoggerFactory.getLogger(AuthorController.class);

    private final AuthorService service;

    public AuthorController(AuthorService service) {
        this.service = service;
    }

    // ✅ Returns only author names
    @GetMapping
    public List<AuthorNameDto> getAllAuthorNames() {
        logger.info("API call: GET /authors");
        return service.getAuthorNames();
    }

    @GetMapping("/{name}")
    public Author getAuthorByName(@PathVariable String name) {
        logger.info("API call: GET /authors/{}", name);
        return service.getAuthorByName(name);
    }
}
