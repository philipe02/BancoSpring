package com.banco.application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banco.application.models.Empregado;

public interface EmpregadoRepository extends JpaRepository<Empregado, Integer> {

}
