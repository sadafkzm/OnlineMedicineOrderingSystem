package com.anu.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anu.dao.MedicineDao;
import com.anu.exception.MedicineNotFoundException;
import com.anu.model.Medicine;
import com.anu.service.*;

import java.util.List;
import java.util.Optional;

@Service
public class MedicineServiceImpl implements MedicineService{

    @Autowired
    private MedicineDao medicineDao;

    public List<Medicine> getAllMedicines() {
        return medicineDao.findAll();
    }

    public Medicine getMedicineById(Long id) {
        return medicineDao.findById(id)
                .orElseThrow(() -> new MedicineNotFoundException("Medicine not found with id: " + id));
    }

    public Medicine getMedicineByName(String name) {
        return medicineDao.findByGenericNameContainingIgnoreCase(name)
                .orElseThrow(() -> new MedicineNotFoundException("Medicine not found with name: " + name));
    }

    public Medicine createMedicine(Medicine medicine) {
        return medicineDao.save(medicine);
    }

    public Medicine updateMedicine(Long id, Medicine updatedMedicine) {
        Medicine existingMedicine = getMedicineById(id);
        // Update existingMedicine with data from updatedMedicine
       
        return medicineDao.save(existingMedicine);
    }

    public void deleteMedicine(Long id) {
        medicineDao.deleteById(id);
    }
    @Override
    public Optional<Medicine> searchMedicineByName(String name) {
        return medicineDao.findByGenericNameContainingIgnoreCase(name);
    }
}
