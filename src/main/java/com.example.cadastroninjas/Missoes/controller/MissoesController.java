package com.example.cadastroninjas.Missoes.controller;

import com.example.cadastroninjas.Missoes.service.MissoesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/missoes")
@RequiredArgsConstructor
public class MissoesController {

    private final MissoesService missoesService;



}
