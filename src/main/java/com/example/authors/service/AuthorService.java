package com.example.authors.service;

import com.example.authors.dto.AuthorNameDto;
import com.example.authors.entity.Author;
import com.example.authors.repository.AuthorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private static final Logger logger = LoggerFactory.getLogger(AuthorService.class);

    private final AuthorRepository repository;

    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }

    public List<AuthorNameDto> getAuthorNames() {
        logger.info("Fetching all author names");
        return repository.findByNameIsNotNull()
                .stream()
                .map(a -> new AuthorNameDto(a.getName()))
                .toList();
    }

    public Author getAuthorByName(String name) {
        logger.info("Fetching author by name: {}", name);
        return repository.findByNameIgnoreCase(name);
    }
}
