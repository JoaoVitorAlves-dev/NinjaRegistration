package com.example.cadastroninjas.Ninjas.service;

import com.example.cadastroninjas.Ninjas.dto.NinjaDTO;
import com.example.cadastroninjas.Ninjas.dto.NinjaMapper;
import com.example.cadastroninjas.Ninjas.entity.NinjaEntity;
import com.example.cadastroninjas.Ninjas.repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    public List<NinjaEntity> listarNinjas() {
        return ninjaRepository.findAll();
    }

    public NinjaEntity listarNinjasPorId(Long id) {
        Optional<NinjaEntity> ninjaEntity = ninjaRepository.findById(id);
        return ninjaEntity.
                orElseThrow(() -> new RuntimeException("Id não encontrado"));
    }

    public NinjaDTO criarNinja(NinjaDTO ninja) {
        NinjaEntity ninjaEntity = ninjaMapper.map(ninja);
        ninjaEntity = ninjaRepository.save(ninjaEntity);
        return ninjaMapper.map(ninjaEntity);
    }

    public NinjaEntity atualizarNinja(Long id, NinjaEntity ninja) {
        if (ninjaRepository.existsById(id)) {
            ninja.setId(id);
            return ninjaRepository.save(ninja);
        }
        throw new RuntimeException("Id já existe");
    }

    public void deletarPorId(Long id) {
        ninjaRepository.deleteById(id);
    }

}
