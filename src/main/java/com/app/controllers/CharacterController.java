package com.app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Character;
import com.app.model.CharacterDTO;
import com.app.services.CharacterService;

@RestController
@RequestMapping("/characters")
public class CharacterController {
    @Autowired
    CharacterService characterService;

    @GetMapping()
    public List<Character> getCharacter(@RequestParam(required=false) String name, @RequestParam(required=false) Integer age, @RequestParam(required=false) Long movies){
        return characterService.personajesPorParametro(name, age, movies);
    }

    @PostMapping()
    public Character saveCharacter(@RequestBody Character character){
        return this.characterService.guardarPersonaje(character);
    }

    @GetMapping( path = "/{id}")
    public Optional<Character> getCharacterById(@PathVariable("id") Long id) {
        return this.characterService.obtenerPorId(id);
    }

    @PatchMapping(path = "/{id}")
    private Character updateCharacter(@PathVariable("id") Long id, @RequestBody CharacterDTO characterDTO) {
		Character character = new Character();
		character.setAge(characterDTO.getAge());
		character.setHistory(characterDTO.getHistory());
		character.setName(characterDTO.getName());
		character.setWeight(characterDTO.getWeight());
		return this.characterService.guardarPersonaje(character);

	}



    @DeleteMapping( path = "/{id}")
    public String deleteCharacter(@PathVariable("id") Long id){
        boolean ok = this.characterService.eliminarPersonaje(id);
        if (ok){
            return "Se eliminó el personaje con id " + id;
        }else{
            return "No pudo eliminar el personaje con id" + id;
        }
    }


}