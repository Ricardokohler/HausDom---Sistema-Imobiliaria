package com.imobiliaria.imobiliaria.controllers;

import com.imobiliaria.imobiliaria.entities.Order;
import com.imobiliaria.imobiliaria.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;


    //Create
    @PostMapping("/add")
    public ResponseEntity <Order> create(@RequestBody Order Order) {
        Order createdOrder = service.create(Order);

        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }


    @GetMapping("/all")
    public ResponseEntity <List<Order>> getAll(){
        List <Order> allProperties = service.getAll();

        return new ResponseEntity<>(allProperties, HttpStatus.OK);
    }



    @GetMapping("/{id}")
    public ResponseEntity <?> getById(@PathVariable Long id){
        Optional<Order> optionalOrder = service.getById(id);

        if (optionalOrder.isPresent()) {

            return new ResponseEntity<>(optionalOrder, HttpStatus.OK);

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity <String> delete(@PathVariable Long id){
        Optional <Order> deletedOrder = service.getById(id);

        if(deletedOrder.isPresent()){
            service.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Order successfully deleted");

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
    }



    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Order Order){

        try{
        Order updatedOrder = service.update(id, Order);
        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);

        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
    }
}
