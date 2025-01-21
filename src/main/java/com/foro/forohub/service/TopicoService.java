package com.foro.forohub.service;

import com.foro.forohub.dto.TopicoRequest;
import com.foro.forohub.dto.TopicoResponse;
import com.foro.forohub.model.Curso;
import com.foro.forohub.model.Topico;
import com.foro.forohub.repository.CursoRepository;
import com.foro.forohub.repository.TopicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public TopicoResponse guardarTopico(TopicoRequest datos) {
        // Buscar el curso por ID
        Curso curso = cursoRepository.findById(datos.getCursoId())
                .orElseThrow(() -> new RuntimeException("El curso con ID " + datos.getCursoId() + " no existe."));

        // Crear y guardar el tópico
        Topico topico = new Topico();
        topico.setTitulo(datos.getTitulo());
        topico.setMensaje(datos.getMensaje());
        topico.setAutor(datos.getAutor());
        topico.setEstado(datos.getEstado());
        topico.setCurso(curso); // Asignar el curso encontrado
        topico.setFechaCreacion(java.time.LocalDateTime.now());

        Topico guardado = topicoRepository.save(topico);

        return new TopicoResponse(
                guardado.getId(),
                guardado.getTitulo(),
                guardado.getMensaje(),
                guardado.getAutor(),
                guardado.getFechaCreacion(),
                guardado.getEstado(),
                guardado.getCurso().getNombre()
        );
    }

    public Optional<TopicoResponse> obtenerPorId(Long id) {
        return topicoRepository.findById(id)
                .map(topico -> new TopicoResponse(
                        topico.getId(),
                        topico.getTitulo(),
                        topico.getMensaje(),
                        topico.getAutor(),
                        topico.getFechaCreacion(),
                        topico.getEstado(),
                        topico.getCurso().getNombre()
                ));
    }
}