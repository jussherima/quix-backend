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
import com.quix.app.model.Utilisateur;
import com.quix.app.repository.UtilisateurRepository;

@RestController
@RequestMapping("/api1")
public class UtilisateurController {
    @Autowired
    UtilisateurRepository user_repository;

    // lister tous les utilisateur
    @GetMapping("/utilisateur")
    public List<Utilisateur> get_all() {
        return user_repository.findAll();
    }

    // ajout de utilisateur ou ajout d'employer dans une hopial
    @PostMapping("/save")
    public Utilisateur create_utilisateur(@Valid @RequestBody Utilisateur usr) {
        return user_repository.save(usr);
    }

    // selectionner les utilisateur par id
    @GetMapping("/utilisateur/{id}")
    public Utilisateur getById(@PathVariable(value = "id") Long idUtilisateur) {
        return user_repository.findById(idUtilisateur)
                .orElseThrow(() -> new ResourceNotFoundException("Utilisateur", "id", idUtilisateur));
    }

    @PutMapping("/utilisateur/{id}")
    public Utilisateur updateUtilisateur(@PathVariable(value = "id") Long id_utilisateur,
            @Valid @RequestBody Utilisateur nouvelleUtilisateur) {
        Utilisateur userNormal = user_repository.findById(id_utilisateur)
                .orElseThrow(() -> new ResourceNotFoundException("Utilisateur", "id", id_utilisateur));

        // mettre a jour les valeurs
        userNormal = nouvelleUtilisateur;
        userNormal.setIdUtilisateur(id_utilisateur);

        return user_repository.save(userNormal);
    }

    @DeleteMapping("/utilisateur/{id}")
    public ResponseEntity<?> deleteUtilisateur(@PathVariable(value = "id") Long idUtilisateur) {
        Utilisateur user = user_repository.findById(idUtilisateur)
                .orElseThrow(() -> new ResourceNotFoundException("Utilisateur", "id", idUtilisateur));
        user_repository.delete(user);
        return ResponseEntity.ok().build();
    }

}
