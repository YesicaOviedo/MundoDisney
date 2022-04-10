package com.app.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Gender;
import com.app.services.GenderService;



@RestController
@RequestMapping("/gender")
public class GenderController {
    @Autowired
    GenderService generoService;

    @GetMapping()
    public ArrayList<Gender> obtenerGenero(){
        return generoService.obtenerGenero();
    }

    @PostMapping()
    public Gender guardarPersonaje(@RequestBody Gender genero){
        return this.generoService.guardarGenero(genero);
    }

}
