package com.example.authors.repository;

import com.example.authors.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByNameIsNotNull();

    Author findByNameIgnoreCase(String name);
}
