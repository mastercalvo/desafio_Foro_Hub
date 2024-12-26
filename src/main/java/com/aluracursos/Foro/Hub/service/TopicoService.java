package com.aluracursos.Foro.Hub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aluracursos.Foro.Hub.model.Topico;
import com.aluracursos.Foro.Hub.repository.TopicoRepository;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    public List<Topico> getAllTopicos() {
        return topicoRepository.findAll();
    }

    public Topico getTopicoById(Long id) {
        return topicoRepository.findById(id).orElse(null);
    }

    public Topico createTopico(Topico topico) {
        return topicoRepository.save(topico);
    }

    public Topico updateTopico(Long id, Topico topicoDetails) {
        Topico topico = topicoRepository.findById(id).orElse(null);
        if (topico != null) {
            topico.setTitulo(topicoDetails.getTitulo());
            topico.setMensaje(topicoDetails.getMensaje());
            topico.setStatus(topicoDetails.getStatus());
            topico.setAutorId(topicoDetails.getAutorId());
            topico.setCursoId(topicoDetails.getCursoId());
            return topicoRepository.save(topico);
        }
        return null;
    }

    public boolean deleteTopico(Long id) {
        if (topicoRepository.existsById(id)) {
            topicoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
