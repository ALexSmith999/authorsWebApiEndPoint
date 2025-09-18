package com.example.authors.controller;

import com.example.authors.dto.AuthorNameDto;
import com.example.authors.entity.Author;
import com.example.authors.service.AuthorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AuthorController.class)
class AuthorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthorService service;

    @Test
    void testGetAllAuthorNames() throws Exception {
        AuthorNameDto dto = new AuthorNameDto("John Doe");
        when(service.getAuthorNames()).thenReturn(List.of(dto));

        mockMvc.perform(get("/authors"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("John Doe"));

        verify(service, times(1)).getAuthorNames();
    }

    @Test
    void testGetAuthorByName() throws Exception {
        Author author = new Author();
        author.setName("Jane Doe");

        when(service.getAuthorByName("Jane Doe")).thenReturn(author);

        mockMvc.perform(get("/authors/Jane Doe"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Jane Doe"));

        verify(service, times(1)).getAuthorByName("Jane Doe");
    }
}
