package com.imobiliaria.imobiliaria.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @OneToMany(mappedBy = "order")
    private List<Property> properties;

    @OneToOne
    @JoinColumn
    private RealStateConsultant consultant;

    @OneToOne
    @JoinColumn
    private Client client;


}
