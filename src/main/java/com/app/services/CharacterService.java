package com.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Character;
import com.app.repositories.CharacterRepository;

@Service
public class CharacterService {
    @Autowired
    CharacterRepository characterRepository;

    public ArrayList<Character> obtenerPersonajes(){
        return (ArrayList<Character>) characterRepository.findAll();
    }

    public Character guardarPersonaje(Character character){
        return characterRepository.save(character);
    }

    public List<Character> personajesPorParametro(String name, Integer age, Long idMovie){
    	return characterRepository.obtenerPersonajePorParametros(name, age, idMovie);
    }

    public Optional<Character> obtenerPorId(Long id){
        return characterRepository.findById(id);
    }

    public boolean eliminarPersonaje(Long id) {
        try{
        	characterRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }



}