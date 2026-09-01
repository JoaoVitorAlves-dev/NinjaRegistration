package com.example.cadastroninjas.Ninjas.controller;

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
    public NinjaEntity criarNinja(@RequestBody NinjaEntity ninja) {
        return ninjaService.criarNinja(ninja);
    }

    @GetMapping("/listar")
    public List<NinjaEntity> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    @GetMapping("/listar/{id}")
    public NinjaEntity mostrarTodosOsNinjasPorId(@PathVariable Long id) {
        return ninjaService.listarNinjasPorId(id);
    }

    //@PutMapping
    @PatchMapping("/alterar/{id}")
    public NinjaEntity alterarNinja(@PathVariable Long id, @RequestBody NinjaEntity ninja) {
        return ninjaService.atualizarNinja(id, ninja);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorId(@PathVariable Long id) {
        ninjaService.deletarPorId(id);
    }

}
