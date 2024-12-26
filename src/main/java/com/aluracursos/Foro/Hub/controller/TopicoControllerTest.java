package com.aluracursos.Foro.Hub.controller;

import static org.mockito.Mockito.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import com.aluracursos.Foro.Hub.service.TopicoService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@WebMvcTest(TopicoController.class)
public class TopicoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private TopicoService topicoService;

    @InjectMocks
    private TopicoController topicoController;

    @Test
    @WithMockUser
    public void testGetTopicos() throws Exception {
        when(topicoService.getAllTopicos()).thenReturn(List.of("Topico 1", "Topico 2"));

        mockMvc.perform(MockMvcRequestBuilders.get("/topicos"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(greaterThan(0))));
    }
}
