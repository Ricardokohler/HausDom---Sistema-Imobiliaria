package com.imobiliaria.imobiliaria.controllers;

import com.imobiliaria.imobiliaria.entities.RealStateConsultant;
import com.imobiliaria.imobiliaria.services.RealStateConsultantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consultants")
public class RealStateConsultantController {

    @Autowired
    private RealStateConsultantService service;


    //Create
    @PostMapping("/add")
    public ResponseEntity <RealStateConsultant> create(@RequestBody RealStateConsultant RealStateConsultant) {
        RealStateConsultant createdRealStateConsultant = service.create(RealStateConsultant);

        return new ResponseEntity<>(createdRealStateConsultant, HttpStatus.CREATED);
    }


    @GetMapping("/all")
    public ResponseEntity <List<RealStateConsultant>> getAll(){
        List <RealStateConsultant> allProperties = service.getAll();

        return new ResponseEntity<>(allProperties, HttpStatus.OK);
    }



    @GetMapping("/{id}")
    public ResponseEntity <?> getById(@PathVariable Long id){
        Optional<RealStateConsultant> optionalRealStateConsultant = service.getById(id);

        if (optionalRealStateConsultant.isPresent()) {

            return new ResponseEntity<>(optionalRealStateConsultant, HttpStatus.OK);

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity <String> delete(@PathVariable Long id){
        Optional <RealStateConsultant> deletedRealStateConsultant = service.getById(id);

        if(deletedRealStateConsultant.isPresent()){
            service.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("RealStateConsultant successfully deleted");

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
    }



    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody RealStateConsultant RealStateConsultant){

        try{
        RealStateConsultant updatedRealStateConsultant = service.update(id, RealStateConsultant);
        return new ResponseEntity<>(updatedRealStateConsultant, HttpStatus.OK);

        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
    }
}
