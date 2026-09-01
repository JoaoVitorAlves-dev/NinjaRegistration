package com.example.cadastroninjas.Ninjas.service;

import com.example.cadastroninjas.Ninjas.entity.NinjaEntity;
import com.example.cadastroninjas.Ninjas.repository.NinjaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NinjaService {

    private final NinjaRepository ninjaRepository;

    public List<NinjaEntity> listarNinjas() {
        return ninjaRepository.findAll();
    }

    public NinjaEntity listarNinjasPorId(Long id) {
        Optional<NinjaEntity> ninjaEntity = ninjaRepository.findById(id);
        return ninjaEntity.
                orElseThrow(() -> new RuntimeException("Id não encontrado"));
    }

    public NinjaEntity criarNinja(NinjaEntity ninja) {
        return ninjaRepository.save(ninja);
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
