package com.aluracursos.Foro.Hub.service;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {

    public List<String> getAllTopicos() {
        // Lógica para obtener todos los tópicos
        return List.of("Topico 1", "Topico 2", "Topico 3");
    }
}
