package com.quix.app.model;

import java.sql.Date;
import java.time.LocalTime;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "disponibilite-medcin")
@EntityListeners(AuditingEntityListener.class)
@Entity
public class DisponibliteMedcin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idDisponibiliteMecin;
    Date date_disponibilite;
    LocalTime debut_heure_disponibilite;
    LocalTime fin_heure_disponibilite;
    int idUtilisateur;
    int idCentre;

    public DisponibliteMedcin() {
    }

    public DisponibliteMedcin(int idDisponibiliteMecin, Date date_disponibilite, LocalTime debut_heure_disponibilite,
            LocalTime fin_heure_disponibilite, int idUtilisateur, int idCentre) {
        this.idDisponibiliteMecin = idDisponibiliteMecin;
        this.date_disponibilite = date_disponibilite;
        this.debut_heure_disponibilite = debut_heure_disponibilite;
        this.fin_heure_disponibilite = fin_heure_disponibilite;
        this.idUtilisateur = idUtilisateur;
        this.idCentre = idCentre;
    }

    public int getIdCentre() {
        return idCentre;
    }

    public void setIdCentre(int idCentre) {
        this.idCentre = idCentre;
    }

    public int getIdDisponibiliteMecin() {
        return idDisponibiliteMecin;
    }

    public void setIdDisponibiliteMecin(int idDisponibiliteMecin) {
        this.idDisponibiliteMecin = idDisponibiliteMecin;
    }

    public Date getDate_disponibilite() {
        return date_disponibilite;
    }

    public void setDate_disponibilite(Date date_disponibilite) {
        this.date_disponibilite = date_disponibilite;
    }

    public LocalTime getDebut_heure_disponibilite() {
        return debut_heure_disponibilite;
    }

    public void setDebut_heure_disponibilite(LocalTime debut_heure_disponibilite) {
        this.debut_heure_disponibilite = debut_heure_disponibilite;
    }

    public LocalTime getFin_heure_disponibilite() {
        return fin_heure_disponibilite;
    }

    public void setFin_heure_disponibilite(LocalTime fin_heure_disponibilite) {
        this.fin_heure_disponibilite = fin_heure_disponibilite;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

}
