package com.peladas.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.peladas.portal.models.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role,Integer>{

	public Role findByRole(String role);
	
}
