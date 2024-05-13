package com.anu.service;

import java.util.List;
import java.util.Optional;

import com.anu.model.Medicine;

public interface MedicineService {
	
	public Medicine getMedicineById(Long id);
	public Medicine getMedicineByName(String name);
	public Medicine createMedicine(Medicine medicine);
	 public Medicine updateMedicine(Long id, Medicine updatedMedicine);
	 public void deleteMedicine(Long id);
	public List<Medicine> getAllMedicines();
	Optional<Medicine> searchMedicineByName(String name);
}
