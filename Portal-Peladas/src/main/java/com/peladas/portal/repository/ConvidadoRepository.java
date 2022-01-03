package com.peladas.portal.repository;

import org.springframework.data.repository.CrudRepository;

import com.peladas.portal.models.Convidado;
import com.peladas.portal.models.Peladas;



public interface ConvidadoRepository extends CrudRepository<Convidado, String> {

	Iterable<Convidado> findByPeladas(Peladas peladas);
	Convidado findByRg(String rg);
	
}
