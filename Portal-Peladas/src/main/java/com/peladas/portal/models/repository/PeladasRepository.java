package com.peladas.portal.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.peladas.portal.models.Peladas;



public interface PeladasRepository extends CrudRepository<Peladas, String> {
	Peladas findByid(long id);
}
