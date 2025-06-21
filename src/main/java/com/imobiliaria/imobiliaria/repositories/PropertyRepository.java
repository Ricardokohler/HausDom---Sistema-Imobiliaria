package com.imobiliaria.imobiliaria.repositories;

import com.imobiliaria.imobiliaria.entities.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long> {
}
