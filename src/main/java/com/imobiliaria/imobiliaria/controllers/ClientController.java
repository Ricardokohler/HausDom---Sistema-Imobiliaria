package com.imobiliaria.imobiliaria.controllers;

import com.imobiliaria.imobiliaria.entities.Client;
import com.imobiliaria.imobiliaria.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService service;


    //Create
    @PostMapping("/add")
    public ResponseEntity <Client> create(@RequestBody Client Client) {
        Client createdClient = service.create(Client);

        return new ResponseEntity<>(createdClient, HttpStatus.CREATED);
    }


    @GetMapping("/all")
    public ResponseEntity <List<Client>> getAll(){
        List <Client> allProperties = service.getAll();

        return new ResponseEntity<>(allProperties, HttpStatus.OK);
    }



    @GetMapping("/{id}")
    public ResponseEntity <?> getById(@PathVariable Long id){
        Optional<Client> optionalClient = service.getById(id);

        if (optionalClient.isPresent()) {

            return new ResponseEntity<>(optionalClient, HttpStatus.OK);

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity <String> delete(@PathVariable Long id){
        Optional <Client> deletedClient = service.getById(id);

        if(deletedClient.isPresent()){
            service.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Client successfully deleted");

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
    }



    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Client Client){

        try{
        Client updatedClient = service.update(id, Client);
        return new ResponseEntity<>(updatedClient, HttpStatus.OK);

        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
    }
}
