package com.imobiliaria.imobiliaria.repositories;

import com.imobiliaria.imobiliaria.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
