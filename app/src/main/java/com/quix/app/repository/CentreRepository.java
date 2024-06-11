package com.quix.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quix.app.model.Centre;

@Repository
public interface CentreRepository extends JpaRepository<Centre, Long> {

}
