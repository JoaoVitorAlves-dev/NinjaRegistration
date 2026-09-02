package com.example.cadastroninjas.Missoes.controller;

import com.example.cadastroninjas.Missoes.dto.MissoesDTO;
import com.example.cadastroninjas.Missoes.service.MissoesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
@RequiredArgsConstructor
public class MissoesController {

    private final MissoesService missoesService;

    @GetMapping
    public ResponseEntity<List<MissoesDTO>> listarTodos() {
        return ResponseEntity.ok().body(missoesService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MissoesDTO> listarPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(missoesService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<MissoesDTO> adicionar(@RequestBody MissoesDTO missoesDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(missoesService.adicionar(missoesDTO));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MissoesDTO> atualizarPorId(@PathVariable Long id, @RequestBody MissoesDTO missoesDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(missoesService.atualizarPorId(id, missoesDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        missoesService.deletarPorId(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
