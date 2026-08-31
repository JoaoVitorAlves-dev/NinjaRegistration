package com.example.cadastroninjas.Missoes.entity;

import com.example.cadastroninjas.Ninjas.entity.NinjaEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@Data
public class MissoesEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeMissao;
    private String dificuldade;

    @OneToMany(mappedBy = "missoes")
    private List<NinjaEntity> ninja;

}
