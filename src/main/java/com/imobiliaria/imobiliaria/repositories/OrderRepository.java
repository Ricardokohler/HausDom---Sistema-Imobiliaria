package com.imobiliaria.imobiliaria.repositories;

import com.imobiliaria.imobiliaria.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
