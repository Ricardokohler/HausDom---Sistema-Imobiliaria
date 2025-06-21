package com.imobiliaria.imobiliaria.services;

import com.imobiliaria.imobiliaria.entities.RealStateConsultant;
import com.imobiliaria.imobiliaria.repositories.RealStateConsultantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RealStateConsultantService {

    @Autowired
    private RealStateConsultantRepository repository;


    //Create
    public RealStateConsultant create(RealStateConsultant RealStateConsultant){
        return repository.save(RealStateConsultant);
    }

    //Get All
    public List <RealStateConsultant> getAll(){
        return repository.findAll();
    }



    //Get By Id
    public Optional <RealStateConsultant> getById (Long id){
        return repository.findById(id);

    }



    //Delete
    public void deleteById(Long id){
        repository.deleteById(id);
    }



    //Update
    public RealStateConsultant update(Long id, RealStateConsultant RealStateConsultant){
        Optional <RealStateConsultant> oldRealStateConsultant = repository.findById(id);

        if(oldRealStateConsultant.isPresent()){
            RealStateConsultant newRealStateConsultant = oldRealStateConsultant.get();

            newRealStateConsultant.setName(RealStateConsultant.getName());
            newRealStateConsultant.setAddress(RealStateConsultant.getAddress());
            newRealStateConsultant.setPhone(RealStateConsultant.getPhone());

            return repository.save(newRealStateConsultant);

        } else {
            throw new RuntimeException("Id não encontrado");
        }


    }

}
