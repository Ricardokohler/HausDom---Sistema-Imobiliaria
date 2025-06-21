package com.imobiliaria.imobiliaria;

import com.imobiliaria.imobiliaria.entities.Client;
import com.imobiliaria.imobiliaria.entities.Order;
import com.imobiliaria.imobiliaria.entities.Property;
import com.imobiliaria.imobiliaria.entities.RealStateConsultant;
import com.imobiliaria.imobiliaria.repositories.ClientRepository;
import com.imobiliaria.imobiliaria.repositories.OrderRepository;
import com.imobiliaria.imobiliaria.repositories.PropertyRepository;
import com.imobiliaria.imobiliaria.repositories.RealStateConsultantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private RealStateConsultantRepository realStateConsultantRepository;


    @Override
    public void run(String... args) throws Exception {

        Client c1 = new Client(null, "Luiz Silva", "Rua da Saudade", 200.0);
        Client c2 = new Client(null, "Maria Oliveira", "Avenida Brasil", 350.0);
        Client c3 = new Client(null, "Carlos Pereira", "Praça da Liberdade", 150.0);
        Client c4 = new Client(null, "Ana Souza", "Rua das Flores", 400.0);
        Client c5 = new Client(null, "João Santos", "Travessa do Mercado", 275.0);
        clientRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5));

        Property p1 = new Property(null, "Casa bonita", "Avenida Luis Lira", 2555000.00);
        Property p2 = new Property(null, "Apartamento moderno", "Rua das Acácias", 850000.00);
        Property p3 = new Property(null, "Sítio dos sonhos", "Estrada do Sol", 1200000.00);
        Property p4 = new Property(null, "Cobertura luxuosa", "Rua São Jorge", 3200000.00);
        Property p5 = new Property(null, "Loft aconchegante", "Travessa Central", 950000.00);
        propertyRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        RealStateConsultant rsc1 = new RealStateConsultant(null, "Rafael Souza", "3645-9864", "Avenida Paulista", 1500.00);
        RealStateConsultant rsc2 = new RealStateConsultant(null, "Fernanda Lima", "9876-1234", "Rua das Palmeiras", 1800.00);
        RealStateConsultant rsc3 = new RealStateConsultant(null, "Marcos Oliveira", "5544-3322", "Praça Sete", 1300.00);
        RealStateConsultant rsc4 = new RealStateConsultant(null, "Juliana Alves", "7788-9900", "Rua do Comércio", 1700.00);
        RealStateConsultant rsc5 = new RealStateConsultant(null, "Eduardo Mendes", "4455-6677", "Avenida Brasil", 1600.00);
        realStateConsultantRepository.saveAll(Arrays.asList(rsc1, rsc2, rsc3, rsc4, rsc5));

        Order o1 = new Order(null,"Lorem ipsum", p1, rsc1, c1);
        Order o2 = new Order(null, "Dolorem tames",p2, rsc2, c2);
        Order o3 = new Order(null, "Teste lokito", p3, rsc3, c3);
        Order o4 = new Order(null, "seloko parcerow", p4, rsc4, c4);
        Order o5 = new Order(null, "Mais uma obra", p5, rsc5, c5);
        orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4, o5));




    }

}
