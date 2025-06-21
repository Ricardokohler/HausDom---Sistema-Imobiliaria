package com.imobiliaria.imobiliaria.services;

import com.imobiliaria.imobiliaria.entities.Client;
import com.imobiliaria.imobiliaria.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;


    //Create
    public Client create(Client Client){
        return repository.save(Client);
    }

    //Get All
    public List <Client> getAll(){
        return repository.findAll();
    }



    //Get By Id
    public Optional <Client> getById (Long id){
        return repository.findById(id);

    }



    //Delete
    public void deleteById(Long id){
        repository.deleteById(id);
    }



    //Update
    public Client update(Long id, Client Client){
        Optional <Client> oldClient = repository.findById(id);

        if(oldClient.isPresent()){
            Client newClient = oldClient.get();

            newClient.setAddress(Client.getAddress());
            newClient.setName(Client.getName());
            newClient.setAddress(Client.getAddress());
            newClient.setAnualIncome(Client.getAnualIncome());

            return repository.save(newClient);

        } else {
            throw new RuntimeException("Id não encontrado");
        }


    }

}
