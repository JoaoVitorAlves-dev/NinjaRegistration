package com.example.cadastroninjas.Ninjas.controller;

import com.example.cadastroninjas.Ninjas.dto.NinjaDTO;
import com.example.cadastroninjas.Ninjas.service.NinjaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
@RequiredArgsConstructor
public class NinjaController {

    private final NinjaService ninjaService;

    @PostMapping("/criar")
    public ResponseEntity<NinjaDTO> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).
                body(novoNinja);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        return ResponseEntity.status(HttpStatus.OK).body(ninjaService.listarNinjas());
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<NinjaDTO> listarNinjasPorId(@PathVariable Long id) {
        NinjaDTO ninja = ninjaService.listarNinjasPorId(id);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //@PutMapping
    @PatchMapping("/alterar/{id}")
    public ResponseEntity<NinjaDTO> alterarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninja) {
        NinjaDTO ninjaDTO = ninjaService.atualizarNinja(id, ninja);
        if (ninjaDTO != null) {
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body(ninjaDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<NinjaDTO> deletarNinjaPorId(@PathVariable Long id) {
        NinjaDTO ninja = ninjaService.listarNinjasPorId(id);
        if (ninja != null) {
            ninjaService.deletarPorId(id);
            return ResponseEntity.ok()
                    .build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

}
