package com.imobiliaria.imobiliaria.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "tb_consultores")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RealStateConsultant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;
    private String address;
    private double salary;

    @JsonIgnore
    @OneToOne(mappedBy = "consultant")
    private Order order;

    public RealStateConsultant(Long id, String name, String phone, String address, double salary) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.salary = salary;
    }
}
