package com.example.cadastroninjas.Ninjas.dto;

import com.example.cadastroninjas.Missoes.entity.MissoesEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

    private Long id;
    private String nome;
    private String email;
    private String imgUrl;
    private Integer idade;
    private String rank;
    private MissoesEntity missoes;

}
