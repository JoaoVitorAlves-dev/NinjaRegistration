package com.example.cadastroninjas.Ninjas.entity;

import com.example.cadastroninjas.Missoes.entity.MissoesEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_cadastro")
@Data
public class NinjaEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Integer idade;
    private String email;

    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissoesEntity missoes;

}
