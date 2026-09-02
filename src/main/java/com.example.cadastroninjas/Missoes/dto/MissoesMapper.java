package com.example.cadastroninjas.Missoes.dto;

import com.example.cadastroninjas.Missoes.entity.MissoesEntity;
import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {

    public MissoesEntity map(MissoesDTO missoesDTO) {
        MissoesEntity missoes = new MissoesEntity();
        missoes.setId(missoesDTO.getId());
        missoes.setNomeMissao(missoesDTO.getNomeMissao());
        missoes.setDificuldade(missoesDTO.getDificuldade());
        missoes.setNinja(missoesDTO.getNinja());
        return missoes;
    }

    public MissoesDTO map(MissoesEntity missoesEntity) {
        MissoesDTO missoesDTO = new MissoesDTO();
        missoesDTO.setId(missoesEntity.getId());
        missoesDTO.setNomeMissao(missoesDTO.getNomeMissao());
        missoesDTO.setDificuldade(missoesDTO.getDificuldade());
        missoesDTO.setNinja(missoesEntity.getNinja());
        return missoesDTO;
    }


}
