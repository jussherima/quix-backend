package com.quix.app.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "centre")
@EntityListeners(AuditingEntityListener.class)
public class Centre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idCentre;
    String type;

    public Centre(int idCentre, String type) {
        this.idCentre = idCentre;
        this.type = type;
    }

    public int getIdCentre() {
        return idCentre;
    }

    public void setIdCentre(int idCentre) {
        this.idCentre = idCentre;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
