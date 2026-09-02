package com.example.cadastroninjas.Ninjas.service;

import com.example.cadastroninjas.Ninjas.dto.NinjaDTO;
import com.example.cadastroninjas.Ninjas.dto.NinjaMapper;
import com.example.cadastroninjas.Ninjas.entity.NinjaEntity;
import com.example.cadastroninjas.Ninjas.repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    public List<NinjaDTO> listarNinjas() {
        List<NinjaEntity> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    public NinjaDTO listarNinjasPorId(Long id) {
        Optional<NinjaEntity> ninjaEntity = ninjaRepository.findById(id);
        return ninjaEntity
                .map(ninjaMapper::map)
                .orElseThrow(() -> new RuntimeException("Id não encontrado"));
    }

    public NinjaDTO criarNinja(NinjaDTO ninja) {
        NinjaEntity ninjaEntity = ninjaMapper.map(ninja);
        ninjaEntity = ninjaRepository.save(ninjaEntity);
        return ninjaMapper.map(ninjaEntity);
    }

    public NinjaDTO atualizarNinja(Long id, NinjaDTO ninja) {
        Optional<NinjaEntity> ninjaExistente = ninjaRepository.findById(id);

        if (ninjaExistente.isPresent()) {
            NinjaEntity ninjaAtualizado = ninjaMapper.map(ninja);
            ninjaAtualizado.setId(id);
            NinjaEntity ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
            return ninjaMapper.map(ninjaSalvo);
        }
        return null;
    }

    public void deletarPorId(Long id) {
        ninjaRepository.deleteById(id);
    }

}
