package com.indra.reactivacioncontratos.repositories;

import com.indra.reactivacioncontratos.models.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratoRepository extends JpaRepository<Contrato, Long> {
}
