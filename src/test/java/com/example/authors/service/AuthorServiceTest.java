package com.example.authors.service;

import com.example.authors.dto.AuthorNameDto;
import com.example.authors.entity.Author;
import com.example.authors.repository.AuthorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AuthorServiceTest {

    @Mock
    private AuthorRepository repository;

    @InjectMocks
    private AuthorService service;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAuthorNames() {
        Author author = new Author();
        author.setName("John Doe");

        when(repository.findByNameIsNotNull()).thenReturn(List.of(author));

        List<AuthorNameDto> result = service.getAuthorNames();
        assertEquals(1, result.size());
        assertEquals("John Doe", result.get(0).getName());

        verify(repository, times(1)).findByNameIsNotNull();
    }

    @Test
    void testGetAuthorByName() {
        Author author = new Author();
        author.setName("Jane Doe");

        when(repository.findByNameIgnoreCase("Jane Doe")).thenReturn(author);

        Author result = service.getAuthorByName("Jane Doe");
        assertNotNull(result);
        assertEquals("Jane Doe", result.getName());

        verify(repository, times(1)).findByNameIgnoreCase("Jane Doe");
    }
}
