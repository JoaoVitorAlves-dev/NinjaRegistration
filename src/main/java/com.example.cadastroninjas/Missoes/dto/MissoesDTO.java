package com.example.cadastroninjas.Missoes.dto;

import com.example.cadastroninjas.Ninjas.entity.NinjaEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissoesDTO {

    private Long id;

    private String nomeMissao;
    private String dificuldade;

    private List<NinjaEntity> ninja;

}
