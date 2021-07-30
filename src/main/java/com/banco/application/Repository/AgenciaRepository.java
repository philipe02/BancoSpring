package com.banco.application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.banco.application.models.Agencia;

public interface AgenciaRepository extends JpaRepository<Agencia, Integer>, JpaSpecificationExecutor<Agencia> {

}
