package com.imobiliaria.imobiliaria.services;

import com.imobiliaria.imobiliaria.entities.Property;
import com.imobiliaria.imobiliaria.repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository repository;


    //Create
    public Property create(Property property){
        return repository.save(property);
    }

    //Get All
    public List <Property> getAll(){
        return repository.findAll();
    }



    //Get By Id
    public Optional <Property> getById (Long id){
        return repository.findById(id);

    }



    //Delete
    public void deleteById(Long id){
        repository.deleteById(id);
    }



    //Update
    public Property update(Long id, Property property){
        Optional <Property> oldProperty = repository.findById(id);

        if(oldProperty.isPresent()){
            Property newProperty = oldProperty.get();

            newProperty.setAddress(property.getAddress());
            newProperty.setTitle(property.getTitle());
            newProperty.setPrice(property.getPrice());

            return repository.save(newProperty);

        } else {
            throw new RuntimeException("Id não encontrado");
        }


    }

}
