package com.imobiliaria.imobiliaria.controllers;

import com.imobiliaria.imobiliaria.entities.Property;
import com.imobiliaria.imobiliaria.services.PropertyService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    private PropertyService service;


    //Create
    @PostMapping("/add")
    public ResponseEntity <Property> create(@RequestBody Property property) {
        Property createdProperty = service.create(property);

        return new ResponseEntity<>(createdProperty, HttpStatus.CREATED);
    }


    @GetMapping("/all")
    public ResponseEntity <List<Property>> getAll(){
        List <Property> allProperties = service.getAll();

        return new ResponseEntity<>(allProperties, HttpStatus.OK);
    }



    @GetMapping("/{id}")
    public ResponseEntity <?> getById(@PathVariable Long id){
        Optional<Property> optionalProperty = service.getById(id);

        if (optionalProperty.isPresent()) {

            return new ResponseEntity<>(optionalProperty, HttpStatus.OK);

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity <String> delete(@PathVariable Long id){
        Optional <Property> deletedProperty = service.getById(id);

        if(deletedProperty.isPresent()){
            service.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Property successfully deleted");

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
    }



    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Property property){

        try{
        Property updatedProperty = service.update(id, property);
        return new ResponseEntity<>(updatedProperty, HttpStatus.OK);

        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
    }
}
