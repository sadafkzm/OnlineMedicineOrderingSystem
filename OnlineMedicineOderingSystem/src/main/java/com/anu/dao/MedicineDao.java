package com.anu.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anu.model.Medicine;

@Repository
public interface MedicineDao extends JpaRepository<Medicine,Long>{
	
	
	Optional<Medicine> findByGenericNameContainingIgnoreCase(String name);
}
