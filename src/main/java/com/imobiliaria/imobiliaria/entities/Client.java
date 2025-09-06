package com.imobiliaria.imobiliaria.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tb_clients")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private double anualIncome;

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private Order order;


    public Client(Long id, String name, String address, double anualIncome) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.anualIncome = anualIncome;
    }
}
