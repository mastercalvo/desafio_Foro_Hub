package com.aluracursos.Foro.Hub.controller;

import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.aluracursos.Foro.Hub.model.Topico;
import com.aluracursos.Foro.Hub.service.TopicoService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

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
        when(topicoService.getAllTopicos()).thenReturn(List.of(
                new Topico(1L, "Topico 1", "Mensaje 1", "abierto", 1L, 1L),
                new Topico(2L, "Topico 2", "Mensaje 2", "cerrado", 1L, 1L)
        ));

        mockMvc.perform(MockMvcRequestBuilders.get("/topicos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(greaterThan(0))))
                .andExpect(jsonPath("$[0].titulo", is("Topico 1")));
    }
}
