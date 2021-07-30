package com.banco.application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banco.application.models.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Integer> {

}
