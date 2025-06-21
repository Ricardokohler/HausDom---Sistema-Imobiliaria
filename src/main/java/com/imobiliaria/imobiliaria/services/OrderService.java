package com.imobiliaria.imobiliaria.services;

import com.imobiliaria.imobiliaria.entities.Order;
import com.imobiliaria.imobiliaria.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;


    //Create
    public Order create(Order Order){
        return repository.save(Order);
    }

    //Get All
    public List <Order> getAll(){
        return repository.findAll();
    }



    //Get By Id
    public Optional <Order> getById (Long id){
        return repository.findById(id);

    }



    //Delete
    public void deleteById(Long id){
        repository.deleteById(id);
    }



    //Update
    public Order update(Long id, Order Order){
        Optional <Order> oldOrder = repository.findById(id);

        if(oldOrder.isPresent()){
            Order newOrder = oldOrder.get();

            newOrder.setClient(Order.getClient());
            newOrder.setConsultant(Order.getConsultant());
            newOrder.setProperty(Order.getProperty());
            newOrder.setObservations(Order.getObservations());

            return repository.save(newOrder);

        } else {
            throw new RuntimeException("Id não encontrado");
        }


    }

}
