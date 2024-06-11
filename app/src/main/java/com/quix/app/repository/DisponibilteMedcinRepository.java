package com.quix.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quix.app.model.DisponibliteMedcin;

@Repository
public interface DisponibilteMedcinRepository extends JpaRepository<DisponibliteMedcin, Long> {

}
