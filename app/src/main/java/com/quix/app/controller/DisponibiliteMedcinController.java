package com.quix.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quix.app.model.DisponibliteMedcin;
import com.quix.app.repository.DisponibilteMedcinRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api_disponibilite_medcin")
public class DisponibiliteMedcinController {
    @Autowired
    DisponibilteMedcinRepository dm_reps;

    // fonction pour ajouter une emploi-du temps au medcin
    public DisponibliteMedcin ajouter_disponibilite(@Valid @RequestBody DisponibliteMedcin disp) {
        return dm_reps.save(disp);
    }

    // fonction pour prendre la liste de disponiblite d'un medcin dans une date

}
