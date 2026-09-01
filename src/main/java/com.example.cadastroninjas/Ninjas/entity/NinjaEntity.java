package com.example.cadastroninjas.Ninjas.entity;

import com.example.cadastroninjas.Missoes.entity.MissoesEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "idade")
    private Integer idade;

    @Column(name = "rank")
    private String rank;

    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissoesEntity missoes;

}
