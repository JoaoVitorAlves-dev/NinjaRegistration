package com.example.cadastroninjas.Missoes.service;

import com.example.cadastroninjas.Missoes.dto.MissoesDTO;
import com.example.cadastroninjas.Missoes.dto.MissoesMapper;
import com.example.cadastroninjas.Missoes.entity.MissoesEntity;
import com.example.cadastroninjas.Missoes.repository.MissoesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MissoesService {

    private final MissoesRepository missoesRepository;
    private final MissoesMapper missoesMapper;

    public List<MissoesDTO> listarTodos() {
        List<MissoesEntity> missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    public MissoesDTO buscarPorId(Long id) {
        Optional<MissoesEntity> missoes = missoesRepository.findById(id);
        return missoes.map(missoesMapper::map)
                .orElseThrow(() -> new RuntimeException("Id não encontrado"));
    }

    public MissoesDTO adicionar(MissoesDTO missoesDTO) {
        MissoesEntity missoesEntity = missoesRepository.save(missoesMapper.map(missoesDTO));
        return missoesMapper.map(missoesEntity);
    }

    public MissoesDTO atualizarPorId(Long id, MissoesDTO missoesDTO) {
        MissoesEntity missoesEntity = missoesRepository.findById(id).orElseThrow(() -> new RuntimeException("Id não existe"));
        MissoesEntity missoesAtualizada = missoesMapper.map(missoesDTO);
        missoesAtualizada.setId(id);
        MissoesEntity missoesSalva = missoesRepository.save(missoesAtualizada);
        return missoesMapper.map(missoesSalva);
    }

    public void deletarPorId(Long id) {
        missoesRepository.deleteById(id);
    }

}
