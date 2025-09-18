package com.example.authors.service;

import com.example.authors.dto.AuthorNameDto;
import com.example.authors.entity.Author;
import com.example.authors.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository repository;

    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }

    public List<AuthorNameDto> getAuthorNames() {
        return repository.findByNameIsNotNull()
                .stream()
                .map(a -> new AuthorNameDto(a.getName()))
                .toList();
    }

    public Author getAuthorByName(String name) {
        return repository.findByNameIgnoreCase(name);
    }
}
