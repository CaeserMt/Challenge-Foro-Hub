package com.foro.forohub.controller;

import com.foro.forohub.dto.TopicoRequest;
import com.foro.forohub.dto.TopicoResponse;
import com.foro.forohub.service.TopicoService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    public TopicoResponse crear(@Valid @RequestBody TopicoRequest datos) {
        return topicoService.guardarTopico(datos);
    }

    @GetMapping("/{id}")
    public Optional<TopicoResponse> obtenerDetalle(@PathVariable Long id) {
        return topicoService.obtenerPorId(id);
    }
}