package com.app.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Gender;
import com.app.repositories.GenderRepository;



@Service
public class GenderService {
	@Autowired
    GenderRepository generoRepository;

    public ArrayList<Gender> obtenerGenero(){
        return (ArrayList<Gender>) generoRepository.findAll();
    }

    public Gender guardarGenero(Gender genero){
        return generoRepository.save(genero);
    }

}
