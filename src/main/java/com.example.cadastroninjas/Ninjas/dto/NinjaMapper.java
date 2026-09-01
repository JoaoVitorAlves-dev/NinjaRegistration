package com.example.cadastroninjas.Ninjas.dto;

import com.example.cadastroninjas.Ninjas.entity.NinjaEntity;
import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {

    public NinjaEntity map(NinjaDTO ninjaDTO) {
        NinjaEntity ninjaEntity = new NinjaEntity();
        ninjaEntity.setId(ninjaDTO.getId());
        ninjaEntity.setNome(ninjaDTO.getNome());
        ninjaEntity.setEmail(ninjaDTO.getEmail());
        ninjaEntity.setImgUrl(ninjaDTO.getImgUrl());
        ninjaEntity.setIdade(ninjaDTO.getIdade());
        ninjaEntity.setRank(ninjaDTO.getRank());
        ninjaEntity.setMissoes(ninjaDTO.getMissoes());
        return ninjaEntity;
    }

    public NinjaDTO map(NinjaEntity ninjaEntity) {
        NinjaDTO ninjaDTO = new NinjaDTO();
        ninjaDTO.setId(ninjaEntity.getId());
        ninjaDTO.setNome(ninjaEntity.getNome());
        ninjaDTO.setEmail(ninjaEntity.getEmail());
        ninjaDTO.setImgUrl(ninjaEntity.getImgUrl());
        ninjaDTO.setIdade(ninjaEntity.getIdade());
        ninjaDTO.setRank(ninjaEntity.getRank());
        ninjaDTO.setMissoes(ninjaEntity.getMissoes());
        return ninjaDTO;
    }

}
