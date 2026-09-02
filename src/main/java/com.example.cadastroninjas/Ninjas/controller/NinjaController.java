package com.example.cadastroninjas.Ninjas.controller;

import com.example.cadastroninjas.Ninjas.dto.NinjaDTO;
import com.example.cadastroninjas.Ninjas.service.NinjaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @GetMapping("/boasvindas")
    @Operation(summary = "Mensagem de boas vindas", description = "Essa rota da uma mensagem de boas vindas para quem acessa ela")
    public String boasvindas() {
        return "Priemira mensagem nessa rota";
    }

    @PostMapping("/criar")
    @Operation(summary = "Cria um novo ninja", description = "Rota cria um novo ninja e insere no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400",
                    description = "Erro na criacao do Ninja")
    })
    public ResponseEntity<NinjaDTO> criarNinja(
            @Parameter(description = "Usuario manda o ninja no corpo da requisicao")
            @RequestBody NinjaDTO ninja) {

        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).
                body(novoNinja);
    }

    @GetMapping("/listar")
    @Operation(summary = "Lista todos os ninjas", description = "Rota lista todos os ninjas")
    @ApiResponse(responseCode = "200", description = "ninjas listados com sucesso")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        return ResponseEntity.status(HttpStatus.OK).body(ninjaService.listarNinjas());
    }

    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista o ninja por Id", description = "Rota lista um ninja pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Ninja encontrado com sucesso"),
            @ApiResponse(responseCode = "404",
                    description = "Ninja não encontrado")
    })
    public ResponseEntity<NinjaDTO> listarNinjasPorId(
            @Parameter(description = "Usuario manda o id no caminho da requisicao")
            @PathVariable Long id) {

        NinjaDTO ninja = ninjaService.listarNinjasPorId(id);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //@PutMapping
    @PatchMapping("/alterar/{id}")
    @Operation(summary = "Altera o ninja", description = "Rota altera um ninja pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Ninja alterado com sucesso"),
            @ApiResponse(responseCode = "404",
                    description = "Ninja nao encontrado, nao foi possivel alterar")
    })
    public ResponseEntity<NinjaDTO> alterarNinjaPorId(
            @Parameter(description = "Usuario manda o id no caminho da requisicao")
            @PathVariable Long id,
            @Parameter(description = "Usuario manda os dados do ninja a ser atualizado no corpo da requisicao")
            @RequestBody NinjaDTO ninja) {

        NinjaDTO ninjaDTO = ninjaService.atualizarNinja(id, ninja);
        if (ninjaDTO != null) {
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body(ninjaDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deleta um ninja por id", description = "Rota deleta um ninja por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Ninja deletado com sucesso"),
            @ApiResponse(responseCode = "404",
                    description = "Ninja nao encontrado, nao foi possivel deletar")
    })
    public ResponseEntity<NinjaDTO> deletarNinjaPorId(
            @Parameter(description = "Usuario manda o id no caminho da requisicao")
            @PathVariable Long id) {

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
