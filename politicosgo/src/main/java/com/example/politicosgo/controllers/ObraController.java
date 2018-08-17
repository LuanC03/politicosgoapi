package com.example.politicosgo.controllers;

import java.util.Collection;

import com.example.politicosgo.entities.Obra;
import com.example.politicosgo.services.ObraService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/obra")
public class ObraController {

    @Autowired
    private ObraService oService;

    @GetMapping
    public Collection<Obra> getObras() {

        return oService.getObras();

    }

    @PostMapping
    public ResponseEntity<String> postObra(Obra obra) {

        return this.oService.putObra(obra);
    }

    @PutMapping
    public ResponseEntity<String> putObra(Obra obra) {

        return this.oService.updateObra(obra);

    }

    @DeleteMapping
    public ResponseEntity<String> deleteObraById(int id) {

        return this.oService.deleteObra(id);

    }

}