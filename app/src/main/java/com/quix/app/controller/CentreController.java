package com.quix.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quix.app.exception.ResourceNotFoundException;
import com.quix.app.model.Centre;
import com.quix.app.repository.CentreRepository;

@RestController
@RequestMapping("/api_centre/")
public class CentreController {
    @Autowired
    CentreRepository cRepository;

    // ajout d'une nouvelle centre
    @PostMapping("/save")
    public Centre ajouterCentre(@Valid @RequestBody Centre nouveauCentre) {
        return cRepository.save(nouveauCentre);
    }

    // lister tous les centre
    @GetMapping("/liste_centre")
    public List<Centre> lister_centre() {
        return cRepository.findAll();
    }

    // prendre une centre par son id
    @GetMapping("/centre/{id}")
    public Centre get_by_id(@PathVariable(value = "id") Long idCentre) {
        return cRepository.findById(idCentre)
                .orElseThrow(() -> new ResourceNotFoundException("Centre", "id", idCentre));
    }

    // mettre a jour une centre
    @PutMapping("/update_centre/{id}")
    public Centre mettre_a_jour(@PathVariable(value = "id") Long idCentre, @Valid @RequestBody Centre centre) {
        // prendre le centre actuelle
        Centre centreActuelle = cRepository.findById(idCentre)
                .orElseThrow(() -> new ResourceNotFoundException("Centre", "id", idCentre));

        // mettre a jour le centre actuelle
        centreActuelle.setType(centre.getType());
        return cRepository.save(centreActuelle);
    }

    // suprimez le centre
    @DeleteMapping("/delete_centre/{id}")
    public ResponseEntity<?> deleteCentre(@PathVariable(value = "id") Long idCentre) {
        Centre centreASuprimez = cRepository.findById(idCentre)
                .orElseThrow(() -> new ResourceNotFoundException("centre", "id", idCentre));
        cRepository.delete(centreASuprimez);

        return ResponseEntity.ok().build();
    }
}
