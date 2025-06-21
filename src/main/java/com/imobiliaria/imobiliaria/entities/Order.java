package com.imobiliaria.imobiliaria.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tb_pedidos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String observations;



    @OneToOne
    @JoinColumn
    private Property property;

    @OneToOne
    @JoinColumn
    private RealStateConsultant consultant;

    @OneToOne
    @JoinColumn
    private Client client;


}
