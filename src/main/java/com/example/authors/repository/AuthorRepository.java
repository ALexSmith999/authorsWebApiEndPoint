package com.example.authors.repository;

import com.example.authors.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    // Find only authors with non-null names
    List<Author> findByNameIsNotNull();

    // Find author by name (case-insensitive)
    Author findByNameIgnoreCase(String name);
}
