package com.example.cadastroninjas.Ninjas.controller;

import com.example.cadastroninjas.Ninjas.dto.NinjaDTO;
import com.example.cadastroninjas.Ninjas.entity.NinjaEntity;
import com.example.cadastroninjas.Ninjas.service.NinjaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
@RequiredArgsConstructor
public class NinjaController {

    private final NinjaService ninjaService;

    @PostMapping("/criar")
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja) {
        return ninjaService.criarNinja(ninja);
    }

    @GetMapping("/listar")
    public List<NinjaDTO> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    @GetMapping("/listar/{id}")
    public NinjaDTO mostrarTodosOsNinjasPorId(@PathVariable Long id) {
        return ninjaService.listarNinjasPorId(id);
    }

    //@PutMapping
    @PatchMapping("/alterar/{id}")
    public NinjaDTO alterarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninja) {
        return ninjaService.atualizarNinja(id, ninja);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorId(@PathVariable Long id) {
        ninjaService.deletarPorId(id);
    }

}
